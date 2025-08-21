/**
 *  Validador de formulário
 * @author Juliano Martins de Souza
 */

function validar() {

	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	let cpf = frmContato.cpf.value
	let rg = frmContato.rg.value

	// Valida nome
	if (nome === "") {
		alert("Preencha o campo nome!")
		frmContato.nome.focus();
		return false;
	}

	// Valida o Telefone
	else if (fone === "") {
		alert("Preencha o campo Telefone!");
		frmContato.fone.focus();
		return false;
	}
	else if (fone.length > 15) {
		alert("Número de telefone inválido");
		frmContato.fone.focus();
		return false;
	}

	// Valida o CPF
	else if (cpf === "") {
		alert("Preencha o campo CPF!")
		frmContato.cpf.focus();
		return false;
	}
	else if (cpf.length > 15) {
		alert("Número de CPF inválido");
		frmContato.fone.focus();
		return false;
	}

	// Valida o RG
	else if (rg === "") {
		alert("Prencha o campo RG!")
		frmContato.rg.focus;
		return false;
	}
	else if (rg.length > 15) {
		alert("Número de telefone inválido");
		frmContato.fone.focus();
		return false;
	}
	else {
		document.forms["frmContato"].submit();
	}

}

