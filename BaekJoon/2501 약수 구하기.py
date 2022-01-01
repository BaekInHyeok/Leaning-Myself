p,q=input().split()
p=int(p)
q=int(q)

ary=[]

for i in range(1,p+1):
    if p%i==0:
        ary.append(i)

if len(ary)<q:
    print(0)
else:
    print(ary[q-1])
        

