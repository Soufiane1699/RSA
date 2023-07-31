import socket
import rsa

# Erstelle einen Socket und verbinde dich mit dem Server
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect(('localhost', 60000))
    # Empfange den öffentlichen Schlüssel
    pubkey = s.recv(1024)
    pubkey = rsa.PublicKey.load_pkcs1(pubkey)
    # Verschlüssle und sende eine Nachricht
    message = b'_hellofriend'
    encrypted_message = rsa.encrypt(message, pubkey)
    s.sendall(encrypted_message)