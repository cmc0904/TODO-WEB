<template>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <nav class="navbar bg-dark border-bottom border-bottom-dark font" data-bs-theme="dark">
    <div class="container-fluid">
      <a class="navbar-brand mx-auto" style="font-family: 'GmarketSansMedium';">#TODO !</a>
    </div>
  </nav>
  <SearchBar msg="Welcome to Your Vue.js App"/>
</template>

<script>
import SearchBar from './components/SearchBar.vue'
// import ToDoList from './components/ToDoList.vue'
export default {
  name: 'App',
  components: {
    // ToDoList,
    SearchBar
  }
}

</script>

<style>

@font-face {
  font-family: 'GmarketSansMedium';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
  font-weight: normal;
  font-style: normal;
}
</style>
