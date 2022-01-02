p,q=input().split()
p=int(p)
q=int(q)

for i in range(min(p,q),0,-1):
    if p%i==0 and q%i==0:
        gcd=i
        break
    
gbd=(p*q)/gcd

print(int(gcd))
print(int(gbd))
