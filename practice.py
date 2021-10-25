#애완동물을 소개해 주세요~
animal = "강아지"
name = "연탄이"
age = 4
hobby = "산책"
is_adult = age>=3

print("우리집 " +animal+"의 이름은 "+name+"예요")
hobby="공놀이"
#print(name+"는 "+str(age)+"살이고 "+hobby+"을 좋아해요")#정수형을 +를 포함한 print문에서 쓰기 위해서는 str로 감싸서 문자형으로 바꾸어주어야 한다
print(name,"는 ",age,"살이고 ",hobby,"을 좋아해요")#,를 이용하여서 문자형으로 바꾸어줄 필요 없이 문자형이 아닌 변수들을 print문에서 쓸 수 있다 단 ,는 띄어쓰기를 가지고 있다

print(name+"는 어른일까요? "+str(is_adult))#여기도 마찬가지

'''이렇게 하면
여러문장에 대한
주석처리 가능'''