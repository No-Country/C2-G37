// local reviews data
const reviews = [
  {
    id: 1,
    name: 'César Mauricio Fierro',
    job: 'Full Stack Developer',
    img: './img/cesar.jpeg',
    text: 'Hola soy de Colombia, me encanta crear cosas nuevas y mis puntos fuertes son Java, JavaScript, Html, CSS, MySql y NodeJs.',
  },
  {
    id: 2,
    name: 'Oriana Pellegrini',
    job: 'Backend Developer',
    img: './img/oriana.jpg',
    text: 'Hola soy de Argentina me encanta linkear front con back, mis puntos fuertes son Java, Spring, MySql, Thymeleaf y GitHub.',
  },
  {
    id: 3,
    name: 'Johana Martinez',
    job: 'Backend Developer',
    img: './img/johana.jpg',
    text: 'Hola soy de Colombia pero vivo en Argentina y mis puntos fuertes son Java, Springboot, MySQL, MongoDB y Git',
  },

  {
    id: 4,
    name: 'William Novoa',
    job: 'Backend Developer',
    img: './img/william.jpg',
    text: 'Hola soy de Colombia, autodidacta en Java, Spring, MySQL, MongoDB y Git',
  },
  {
    id: 5,
    name: 'Elías Yoc',
    job: 'Frontend Developer',
    img: './img/elias.jpg',
    text: 'Hola soy de Mexico, soy autodidacta y mis puntos fuertes son Html, CSS, JavaScript, React, Redux, Toolkit y Git',
  },
];

// select items
const img = document.getElementById('person-img');
const author = document.getElementById('author');
const job = document.getElementById('job');
const info = document.getElementById('info');

const prevBtn = document.querySelector('.prev-btn');
const nextBtn = document.querySelector('.next-btn');
const randomBtn = document.querySelector('.random-btn');

// set starting item

let currentItem = 0;

// load initial item
window.addEventListener('DOMContentLoaded', function () {
  showPerson();
});

// show person based on item
function showPerson() {
  const item = reviews[currentItem];
  img.src = item.img;
  author.textContent = item.name;
  job.textContent = item.job;
  info.textContent = item.text;
}

// show next person

nextBtn.addEventListener('click', function () {
  currentItem++;
  if (currentItem > reviews.length - 1) {
    currentItem = 0;
  }
  showPerson();
});

// show next person
prevBtn.addEventListener('click', function () {
  currentItem--;
  if (currentItem < 0) {
    currentItem = reviews.length - 1;
  }
  showPerson();
});

// show random person

randomBtn.addEventListener('click', function () {
  currentItem = Math.floor(Math.random() * reviews.length);
  showPerson();
});
