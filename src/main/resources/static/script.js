let user ={
    id:"1",
    name: "Aman",
    email: "example@mail.com",
    password:"JsExample123",
    isAuthorised: false,
};


let publication={
    id:"1",
    Picture:"/picture.img" ,
    description :"Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    date:"15.12.15",
    User :user,
    Comment: comment[],
    // создал обьект user в к класс publication
}

let comment={
    id: "1",
    description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
    date:"01.12.16",
    // добавил обект comment в к класс publication
}

const publications = [];

function addPublication(pub1) {
   addPublication(publications.push(pub1))
}
