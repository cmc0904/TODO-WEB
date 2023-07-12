<template>
    <!-- <div class="search-container">
        <input v-model="title" type="text" class="search-input" placeholder="일정을 입력하세요">
        <button @click = "fetchData();" class="search-button">추가</button>
    </div> -->

    <div class="search-container">
      <input v-model="title" type="text" class="search-input" placeholder="일정을 입력하세요">
      <input v-model="time" type="time" class="time-input" placeholder="시간을 선택하세요">
      <input v-model="date" type="date" class="date-input" placeholder="날짜를 선택하세요">
      <button @click = "postData();" class="search-button">추가</button>
    </div>
    <hr>
    <!-- <ToDoList msg="Welcome to Your Vue.js App"/> -->
    <ToDoList :key="refreshKey" :data="todoData" />
</template>

<script>
import axios from 'axios';
import ToDoList from './ToDoList.vue'
export default {
  components: {
    ToDoList
  },
  data() {
    return {
      data: [],
      title: '',
      time: '',
      date: '',
      refreshKey: 0 // 새로고침을 위한 key
    };
  },
  methods: {
    async postData() {
      try {
        await axios.post(`http://localhost:8081/api/todo/postTodoContent?title=${this.title}&dt=${this.date}%20${this.time}:00`); // API 엔드포인트에 맞게 URL을 변경하세요
        this.refreshTodoList();
        this.resetInputs();
      } catch (error) {
        console.error(error);
      }
    },

    refreshTodoList() {
      this.refreshKey += 1; // key 값을 변경하여 ToDoList 컴포넌트를 새로고침
    },
    resetInputs() {
      this.title = '';
      this.time = '';
      this.date = '';
    }
  },
};

</script>

<style scoped>
.search-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  font-family: 'GmarketSansMedium';
}
    
.search-input {
  border: 1px solid black;
  border-radius: 5px;
  flex: 1;
  padding: 10px;
  outline: none;
}

.search-button {
  border: 1px solid black;
  border-radius: 5px;
  padding: 10px;
  margin-left: 3px;
  background-color: blue;
  color: white;
  cursor: pointer;
  width: 20%;
  max-width: 80px;
}

.time-input, .date-input {
  border: 1px solid black;
  border-radius: 5px;
  padding: 10px;
  outline: none;
  width: 140px;
  margin-left: 5px;
}
</style>