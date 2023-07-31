# Encryption and decryption
# rsa.encrypt() or rsa.decrypt()
import rsa
# Alice wants to send a message that only Bob can read

import rsa
(bob_pub, bob_priv) = rsa.newkeys(512)

# Alice writes a message, and encodes it in UTF-8. The RSA module only operates on bytes
message = 'Hello Bob from Alice'.encode('utf8')

# Alice encryptes the message using Bob's public key, and sends the encrypted message to Bob.
crypto = rsa.encrypt(message, bob_pub)

# Bob receives the message, and decryptes it with his private key.
message = rsa.decrypt(crypto, bob_priv)
print(message.decode('utf8'))
