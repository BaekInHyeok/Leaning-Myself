const quotes=[

    {
        quote:"전투를 앞둔 병사의 눈빛을 본 적이 있는 사람이라면 전쟁을 하자는 말을 하지 못할 것이다.",
        author:"오토 폰 비스마르크",
    },

    {
        quote:"전투를 앞둔 병사의 눈빛을 본 적이 있는 사람이라면 전쟁을 하자는 말을 하지 못할 것이다.",
        author:"오토 폰 비스마르크",
    },

    {
        quote:"전투를 앞둔 병사의 눈빛을 본 적이 있는 사람이라면 전쟁을 하자는 말을 하지 못할 것이다.",
        author:"오토 폰 비스마르크",
    },

    {
        quote:"겪어보지 못한 자에게 전쟁이란 달콤한 것이다.",
        author:"에라스무스",
    },

    {
        quote:"늙은이들이 전쟁을 선포한다. 그러나 싸워야 하고 죽어야 하는 것은 젊은이들이다.",
        author:"허버트 후버",
    },

    {
        quote:"무기는 설사 백 년 동안 쓸 일이 없다 해도, 단 하루도 갖추지 않을 수 없다.",
        author:"정약용",
    },

    {
        quote:"인류가 전쟁의 종말을 이룩해야 한다. 그렇지 않으면 전쟁이 인류의 종말을 가져다 줄 것이다.",
        author:"허버트 조지 웰즈",
    },

    {
        quote:"제3차 세계대전에서는 어떤 무기가 쓰일지는 모르겠지만, 제4차 세계대전에서는 분명히 돌과 나무 막대가 쓰일 것이다.",
        author:"알베르트 아인슈타인",
    },

    {
        quote:"평화로울 때는 자식이 부모를 땅에 묻는다. 전쟁이 일어나면 부모가 자식을 땅에 묻는다.",
        author:"헤로도토스",
    },

    {
        quote:"똑똑히 말해두는데, 전쟁은 지옥이야!",
        author:"윌리엄 테쿰세 셔먼",
    },
    
]

const quote=document.querySelector("#quote span:first-Child")
const author=document.querySelector("#quote span:last-Child")

const todaysQuote=quotes[Math.floor(Math.random()*quotes.length)]

quote.innerText=todaysQuote.quote
author.innerText=todaysQuote.author