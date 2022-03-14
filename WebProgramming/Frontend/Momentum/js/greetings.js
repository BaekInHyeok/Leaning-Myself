const loginForm=document.querySelector("#login-form")
const loginInput=document.querySelector("#login-form input")
const greeting=document.querySelector("#greeting")

const HIDDEN_CLASSNAME="hidden"
const USERNAME_KEY="username"



function onLoginSubmit(event){
    
    event.preventDefault()//브라우저의 기본동작(새로고침,페이지 이동 등)을 막아준다
    loginForm.classList.add(HIDDEN_CLASSNAME)//loginForm화면을 브라우저에서 숨긴다

    const username=loginInput.value
    localStorage.setItem(USERNAME_KEY,username)//localStorage에 입력받은 username을 저장한다.

    paintGreetings(username)
}

//Hello username을 출력하는 function
function paintGreetings(username){
    greeting.innerText=`Hello ${username}`//브라우저 화면에 Hello username을 출력한다.
    greeting.classList.remove(HIDDEN_CLASSNAME)//숨겨진 상태를 해제한다
}

const savedUsername=localStorage.getItem(USERNAME_KEY)//LocalStorage에 있는 데이터를 가져온다

if(savedUsername==null){
    loginForm.classList.remove(HIDDEN_CLASSNAME)
    loginForm.addEventListener("submit",onLoginSubmit)
}else{
    paintGreetings(savedUsername)
}