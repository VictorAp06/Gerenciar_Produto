<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Produtos Front</a>
      </div>
    </nav>

    <div class="container">

      <form @submit.prevent="salvar">

          <label>Código Produto</label>
          <input type="number" maxlength="4" minlength="4" placeholder="Código Produto" v-model="produto.codProduto">
          
          <label>Nome</label>
          <input type="text" maxlength="75" placeholder="Nome" v-model="produto.nome">
          
          <label>Valor</label>
          <input type="text" maxlength="10" placeholder="Valor" v-model="produto.valor">
          
          <label>Estoque</label>
          <input type="number" maxlength="10" minlength="1" placeholder="Quantidade" v-model="produto.estoque">
          
          <label>Cidade</label>
          <select class="browser-default" v-model="produto.cidade">
            <option selected disabled>Selecione</option>
            <option v-for="cidade of cidades" :key="cidade.id" v-bind:value="{ id: cidade.id, nome: cidade.nome }" >{{cidade.nome}}</option>
          </select>

         <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr>
            <th>Id</th>
            <th>Código</th>
            <th>Nome</th>
            <th>Valor</th>
            <th>Estoque</th>
            <th>Cidade</th>
            <th>Opções</th>
          </tr>

        </thead>

        <tbody>

          <tr>

            <td style="width: 100px"><input type="number" maxlength="10" placeholder="Valor" v-model="id"></td>
            <td colspan="5"></td>
            <td><button @click="listarProduto(id)" class="waves-effect btn-small blue darken-1"><i class="material-icons">search</i></button></td>

          </tr>

          <tr v-for="produto of produtos" :key="produto.id"> 

            <td>{{ produto.id }}</td>
            <td>{{ produto.codProduto }}</td>
            <td>{{ produto.nome }}</td>
            <td>{{ produto.valor }}</td>
            <td>{{ produto.estoque }}</td>
            <td>{{ produto.cidade.nome }}</td>
            <td>
              <button @click="editar(produto)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="deletar(produto)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>


import Produto from './services/produtos'
import Cidade from './services/cidades'

export default {

  data(){
    return {
      id: '',
      produto: {
        id: '',
        codProduto: '',
        nome: '',
        valor: '',
        estoque: '',
        cidade: {
            id: '',
            nome: ''
        }
      },
      atualizaProduto: {
        id: '',
        codProduto: '',
        nome: '',
        valor: '',
        estoque: '',
        cidade: {
            id: '',
            nome: ''
        }
      },
      produtos:[],
      cidades:[]
    }
  },

  mounted(){
    this.listar()
    this.listarCidades()
  },

  methods:{
    listarProduto(id){
      Produto.listarProduto(id).then(resposta => {
        console.log(resposta.data)
        this.produtos = resposta.data
    })},
    listar(){
      Produto.listar().then(resposta => {
        this.produtos = resposta.data
    })},
    listarCidades(){
      Cidade.listar().then(resposta => {
        this.cidades = resposta.data
    })},
    salvar(){
      if(!this.produto.id){
        Produto.salvar(this.produto).then(resposta => {
          this.resposta = resposta
          alert('Produto salvo com sucesso')
          this.listar()
          this.produto = {}
        })
      }else{
        this.atualizaProduto = this.produto
        Produto.atualizar(this.atualizaProduto).then(resposta => {
        this.resposta = resposta
        alert('Produto atualizado com sucesso')
        this.listar()
        this.produto = {}
        })
      }
    },
    editar(produto){
      this.produto = produto
    },
    deletar(produto){
      Produto.deletar(produto).then(resposta => {
      this.resposta = resposta
      alert('Produto deletado com sucesso')
      this.listar()
      })
    }
  }
}
</script>

<style>
  button {
    margin: 3px
  }
</style>
