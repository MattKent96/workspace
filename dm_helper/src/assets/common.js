// Function to more easily select elements by id
let pkr = (id) => {
    return document.getElementById(id);
}

// Global Variables
const dndApiBaseUrl = "http://dnd5eapi.co/api/";
const monstersUrl = "/monsters/";
let monsterNameList = {};
let monsterObjList = {};

// The base API call to get the names and indexes of all the monsters
let getAllMonsterNames = () => {
    fetch(dndApiBaseUrl + monstersUrl)
        .then( (response) => {
            return response.json();
        })
        .then( (json) => {
            ulMonsterList = pkr("ul-monster-list");
            monsterNameList = json.results;

            MonsterNameList.forEach((monster) => {
                var node = document.createElement("li");
                node.appendChild(document.createTextNode(monster.name));
                ulMonsterList.appendChild(node);
            });
        });
};

// The API calls that will get all the details of all the monsters
var getAllMonsterInfo = () => {
    var monsterObjs = monsterNameList;
    monsterObjs.forEach( (monster) => {
        fetch(monster.url).then( (response) => {
            return response.json();
        })
        .then( (json) => {
            var fullMonsterObj = json;
            monsterObjList[monsterObjList.length] = fullMonsterObj;
        })
    });
    return monsterObjList;
};