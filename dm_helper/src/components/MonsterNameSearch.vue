<template>
    <div id="monster-name-search">
        <input type="text" id="txt-monster-name-search" placeholder="Search..." v-on:keyup="filterByName()"/>
    </div>
</template>

<script>
export default  {
    name: 'MonsterNameSearch',
    mounted() {
        let commonJs = document.createElement("script");
        commonJs.setAttribute('src', "../assets/common.js");
        document.head.appendChild(commonJs);
    },
    methods : {
        filterByName : () => {
            let searchBarText = $("txt-monster-name-search").innerText;
            let results = monsterObjList;
            results.filter( (monster) => {
                let monsterName = monster.name.toLowerCase();
                return monsterName.includes(searchBarText);
            });
        }
    }
}
</script>

<style>

</style>