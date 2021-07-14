import { http } from './config'

export default {

    listar:() => {
        return http.get('products')
    },

    salvar:(produto) => {
        return http.post('products/saveProduto', produto)
    },

    atualizar:(produto) => {
        return http.put('products/', produto)
    },

    deletar:(produto) => {
        return http.delete('products/', {data: produto})
    },

    listarProduto:(id) => {
        return http.get('products?id=' + id)
    }

}