import socket
import rsa

(pubkey, privkey) = rsa.newkeys(512)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind(('localhost', 41414))
    s.listen()
    conn, addr = s.accept()

    with conn:
        print('Connected by', addr)
        while True:
            data = conn.recv(1024)
            if not data:
                break
            if data.decode() == 'quit':
                print('Client requested to quit')
                break
            else:
                print('Received', data)

'''
In this example, the server stays in a loop waiting for data from the client. If the data is the string 'quit',
the loop is terminated and the connection is closed. Otherwise, the received data is processed and the server waits for
the next message.
'''