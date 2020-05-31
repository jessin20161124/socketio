package main

import (
	"bufio"
	"github.com/zhouhui8915/go-socket.io-client"
	"log"
	"os"
)

func main() {

	opts := &socketio_client.Options{
		Transport: "websocket",
		Query:     make(map[string]string),
	}
	opts.Query["loginUserNum"] = "89"
	uri := "http://localhost:9099"

	// 这个client不会自动重连...
	client, err := socketio_client.NewClient(uri, opts)
	log.Printf("NewClient success\n")
	if err != nil {
		log.Printf("NewClient error:%v\n", err)
		return
	}

	client.On("error", func() {
		log.Printf("on error\n")
	})
	client.On("connect", func() {
		log.Printf("on connect\n")
	})
        // 事件key，必须前后端一致，对应一个data
	client.On("push_event", func(msg string) {
		log.Printf("on message:%v\n", msg)
	})
	client.On("disconnection", func() {
		log.Printf("on disconnect\n")
	})

	reader := bufio.NewReader(os.Stdin)
	for {
		data, _, _ := reader.ReadLine()
		command := string(data)
		// 对应的key，与后端对应
		client.Emit("push_event", command)
		log.Printf("send message:%v\n", command)
	}
}

