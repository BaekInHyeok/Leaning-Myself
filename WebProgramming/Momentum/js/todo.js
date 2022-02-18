const toDoForm=document.getElementById("todo-form")
const toDoInput=toDoForm.querySelector("#todo-form input")
const toDoList=document.getElementById("todo-list")

const TODOS_KEY="todos"

let toDos=[]//ToDo 데이터가 저장될 빈 array

//LocalStorage에 입력칸에 작성한 내용을 저장하는 함수
function saveToDos(){
    localStorage.setItem(TODOS_KEY,JSON.stringify(toDos))//JSON.stringify 처리하면 로컬스토리지에 string 형식으로 저장된다 ex) [a,b,c,d] -> "[a,b,c,d]"
    //TODOS_KEY 부분이 저장되는 내용의 key값이 된다
}

//리스트에서 삭제버튼을 누르면 실행되는 함수. 리스트와 LocalStorage에서 모두 지운다.
function deleteToDo(event){
    const li=event.target.parentElement//target : 클릭된 html의 요소에 접근할 수 있게 한다. parentElemnt : 클릭된 html 요소가 가지고 있는 모두 데이터 요소들에 접근한다.
    li.remove()//화면에서 삭제
    toDos=toDos.filter(toDo => toDo.id !== parseInt(li.id))//filter()을 이용해 삭제 버튼을 누른 경우 id를 이용해 toDos array에서 해당 요소를 삭제한다.
    saveToDos()//변경이 완료된 toDos array를 LocalStorage에 업데이트한다.
}

//화면에 등록한 리스트를 표시하는 함수
function paintToDo(newTodoobj){

    //newToobj의 id 부분을 li에 저장
    const li = document.createElement("li")
    li.id = newTodoobj.id

    //newToobj의 text 부분을 span에 저장
    const span = document.createElement("span")
    span.innerText = newTodoobj.text;

    const button = document.createElement("button")
    button.innerText = "❌"
    button.addEventListener("click", deleteToDo)

    //span과 button을 li의 자식요소로 삽입
    li.appendChild(span)
    li.appendChild(button)

    //li를 toDoList의 자식요소로 삽입해 해당 위치에 ToDoList가 표시되도록 한다.
    toDoList.appendChild(li)
}

//ToDo함수. 작성창에 내용을 입력하고 Enter를 누르면 작동한다.
function handleToDoSubmit(event){
    event.preventDefault()
    const newTodo=toDoInput.value//작성된 내용을 newTodo에 저장
    toDoInput.value=""//작성창 지우기

    //데이터를 저장할 때 내용이 중복되는 경우 구분할 수 있도록 Date.now()함수를 이용해 id를 생성해 부여한다.
    const newTodoobj={
        text:newTodo,
        id:Date.now(),
    }

    toDos.push(newTodoobj)//toDos array에 newTodoobj 추가
    paintToDo(newTodoobj)//화면에 데이터 표시
    saveToDos()//LocalStorage에 내용 업데이트
}

//ToDo 입력창에 이벤트리스너 추가
toDoForm.addEventListener("submit",handleToDoSubmit)

const savedToDos=localStorage.getItem(TODOS_KEY)//키값을 이용해 LocalStorage에 저장되어있는 데이터를 불러온다

if(savedToDos!==null){
    const parsedToDos=JSON.parse(saveToDos)//JSON.parse()를 이용해 JavaScript가 이해할 수 있는 array로 만들 수 있다.
    toDos=parsedToDos//toDos에 array로 변환된 LocalStorage 데이터를 넣는다.
    parsedToDos.forEach(paintToDo)//array에 저장되어 있는 리스트 요소 전체들을 브라우저 위에 표현한다
}