A,B=input().split()
A=int(A)
B=int(B)

arr=[]
Number=1#배열에 들어갈 데이터
ptr=0#배열 인덱스를 가리키는 포인터
count=0#해당 데이터의 개수
sum=0#범위 내 데이터들의 합

while(ptr<B):
    count=0
    while(count<Number):
        arr.append(Number)
        count+=1
        ptr+=1
    Number+=1

print(arr)    
for i in range(A-1,B):
    sum=sum+arr[i]
    
print(sum)
    