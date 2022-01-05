arr=[]
for i in range(9):
    arr.append(int(input()))

sum=sum(arr)

finished=False

for i in range(8):#i=첫번째 난쟁이
    for j in range(i+1,9):#j=두번째 난쟁이
        if arr[i]+arr[j]==sum-100:
            Spy=[i,j]
            finished=True
            break
    if(finished):
        break

del arr[Spy[0]]
del arr[Spy[1]-1]

arr.sort()

for i in arr:
    print(i)