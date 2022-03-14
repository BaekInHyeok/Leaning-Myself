import tkinter.messagebox as msgbox
from tkinter import *

root=Tk()
root.title("Emmet's GUI")
root.geometry("640x480")

#기차 예매 시스템이라고 가정
def info():
    msgbox.showinfo("알림","정상적으로 예매가 완료되었음")

def warn():
     msgbox.showwarning("경고","해당 좌석은 예매 불가능함")

def err():
     msgbox.showerror("에러","결제 오류 발생")

def okcancel():
     msgbox.askokcancel("확인 / 취소","해당 좌석은 유아동반석입니다. 예매하시겠습니까?")

def retrycancel():
     response=msgbox.askretrycancel("재시도 / 취소","오류 발생. 다시 시도하시겠습니까?")
     if response==1:
             print("yes")
     elif response==0:
         print("no")


def yesno():
     msgbox.askyesno("예 / 아니오","역방향 좌석입니다. 예매하시겠습니까?")

def yesnocancel():
     response=msgbox.askyesnocancel(title=None,message="저장하시겠습니까?")
     #네 : 저장 후 종료
     #아니오 : 저장하지 않고 종료
     #취소 : 프로그램 종료 취소
     print("응답:",response)#True,False,None->예 1, 아니오 0, 그외
     if response==1:
         print("yes")
     elif response==0:
         print("no")
     else:
         print("cancel")


Button(root, command=info,text="알림").pack()
Button(root, command=warn,text="경고").pack()
Button(root, command=err,text="경고").pack()
Button(root, command=okcancel,text="확인 / 취소").pack()
Button(root, command=retrycancel,text="재시도 / 취소").pack()
Button(root, command=yesno,text="예/아니오").pack()
Button(root, command=yesnocancel,text="예/아니오/취소").pack()

root.mainloop()