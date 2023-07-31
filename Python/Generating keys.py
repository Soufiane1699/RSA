import rsa
(pubkey, privkey) = rsa.newkeys(nbits=2048, accurate=True)
# Generates public and private keys, and returs them as (pub, priv)
# (pubkey, privkey) is a Tuple
# In my environment the key generation takes 3 seconds

print(pubkey)
print(privkey)
