const images=["Page1.jpg","Page2.jpg","Page3.jpg"]
const chosenImage=images[Math.floor(Math.random()*images.length)]

const BGImage=document.createElement("img")

BGImage.src=`img/${chosenImage}`

document.body.appendChild(BGImage)