
import { useState } from 'react';
function App() {
  const[todo,setTodo]=useState("");
  const[todos,setTodos]=useState([]);//todo들을 저장할 array 형식의 컴포넌트
  const onChange=(event)=>setTodo(event.target.value);
  const onSubmit=(event)=>{
    event.preventDefault();
    if(todo===""){
      return;
    }
    setTodo("");
    setTodos(currentArray=>[todo,...currentArray])//...을 하지 않으면 [todo,currentArray]의 이중 array가 된다
  }
  //명심하자. jsx에서 javascript 요소를 넣을려면 꼭 {}를 이용하자!
  return (
    <div>
      <h1>My Todos ({todos.length})</h1>
      <form onSubmit={onSubmit}>
        <input 
          onChange={onChange}
          value={todo}
          type="text"
          placeholder="Write your to do..."
        />
        <button>ADD To Do</button>
      </form>
    </div>
  );
}

export default App;
