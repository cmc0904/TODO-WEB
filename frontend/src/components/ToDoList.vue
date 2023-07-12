<template>
    <div id="todo-body">
    <span>TODAY'S TODO LISTS</span>

    <div id="todo-lists">
      <div class="container" v-for="item in data" :key="item.id">
        <div>
          <div class="todo-name">일정 이름: {{item.title}}</div>
          <div class="todo-date">일정 시간: {{item.date}}</div>
        </div>

        <div class="todo-btn">
          <button class="edit-button" data-bs-toggle="modal" data-bs-target="#staticBackdrop">수정</button>
          <button class="delete-button" @click = "delData(item.id);">삭제</button>
           <!-- <EditDelButtons msg="Welcome to Your Vue.js App"/> -->
           <div class="status-indicator">
            <span>상태: {{ item.status }}</span>
          </div>
        </div>
      </div>
    </div>
  </div> 
</template>


<script>
import axios from 'axios';
// import EditDelButtons from './EditDelButtons.vue'
export default {
  // components: {
  //   EditDelButtons
  // },
  data() {
    return {
      data: [],
    };
  },
  mounted() {
    this.fetchData();
  },

  methods: {

    async fetchData() {
      try {
        const response = await axios.get('http://localhost:8081/api/todo/getTodoLists'); // API 엔드포인트에 맞게 URL을 변경하세요
        this.data = response.data;
      } catch (error) {
        console.error(error);
      }
    },

    async updateData() {
      // try {
      //   const response = await axios.get('http://localhost:8081/api/todo/getTodoLists'); // API 엔드포인트에 맞게 URL을 변경하세요
      //   this.data = response.data;
      // } catch (error) {
      //   console.error(error);
      // }
    },

    async delData(id) {
      try {
        await axios.get('http://localhost:8081/api/todo/deleteTodoContent?id='+id); // API 엔드포인트에 맞게 URL을 변경하세요
        this.fetchData();
      } catch (error) {
        console.error(error);
      }
    },
  },


};
</script>


<style scoped>
.todo-name {
  font-size: 20px;
}
#todo-body span {
  font-family: 'GmarketSansMedium';
  margin-left: 5px;
  font-size: 15px;
}

.container {
  font-family: 'GmarketSansMedium';
  max-width: 100%;
  width: 100%;
  margin: 20px auto 20px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  padding: 20px;
  border-radius: 8px;
  position: relative;
  display: flex; /* Add this line */
  align-items: center; /* Add this line */
  justify-content: space-between; /* Add this line */
}

.todo-date {
  margin-top: 3px;
  font-size: 15px;
}

.status-indicator {
  font-family: 'GmarketSansMedium';
  margin-top: 5px;
  color: gray;
}

.delete-button {
  background-color: red;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 5px 10px;
  margin-left: 5px;
  cursor: pointer;
}

.edit-button {
  background-color: green;
  color: white;
  border: none;
  border-radius: 5px;
  padding: 5px 10px;
  margin-left: 5px;
  cursor: pointer;
}
</style>