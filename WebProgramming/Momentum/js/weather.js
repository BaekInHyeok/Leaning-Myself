const API_KEY="6cce86496611ca7675eef9040684b867"

function onGeoSuccess(position){
    const lat=position.coords.latitude
    const lon=position.coords.longitude
    console.log("You live here",lat,lon)
    const url=`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${API_KEY}&units=metric`
    fetch(url)//fatch를 통해 javascript가 url을 호출한다
        .then(response=>response.json())
        .then(data=>{
            const weather=document.querySelector("#weather span:first-child")
            const city=document.querySelector("#weather span:last-child")

            city.innerText=data.name
            weather.innerText=`${data.weather[0].main} / ${data.main.temp}`
    })
}

function onGeoFail(){
    alert("Fail. No weater for you")
}

navigator.geolocation.getCurrentPosition(onGeoSuccess,onGeoFail)