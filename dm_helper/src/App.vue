<template>
  <div id="app">
    <h1>This Header is to Verify the Page is Displaying</h1>
  </div>
</template>

<script>
import MonsterNameSearch from 'components/MonsterNameSearch.vue'
import MonsterCRSearch from 'components/MonsterCRSearch.vue'
import MonsterSizeSearch from 'components/MonsterSizeSearch.vue'

export default {
  name: 'app',
  components: {
    MonsterNameSearch,
    MonsterCRSearch,
    MonsterSizeSearch
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
