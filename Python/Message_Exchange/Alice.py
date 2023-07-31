import socket
import rsa

# Generiere ein neues RSA Schlüsselpaar
(pubkey, privkey) = rsa.newkeys(512)

# Erstelle einen Socket und binde ihn an einen Port
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind(('localhost', 60000))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        # Sende den öffentlichen Schlüssel
        conn.sendall(pubkey.save_pkcs1())
        # Empfange und entschlüssle die Nachricht
        encrypted_message = conn.recv(1024)
        decrypted_message = rsa.decrypt(encrypted_message, privkey)
        print('Received', decrypted_message)
