/**
 * Confirmação de exclusão de um contato
 * @author Juliano Martins de Souza
 */


function confirmar(idCliente){
	let resposta = confirm("Você deseja realmente excluir este contato?")
	
	if(resposta === true) {
		window.location.href = "excluir?idCliente=" + idCliente;
	}
}