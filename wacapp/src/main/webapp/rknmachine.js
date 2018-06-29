function insert(num){
	document.form.textview.value = document.form.textview.value+num
}

function equal(){
	var q = document.form.textview.value;
	if (q){
		document.form.textview.value = eval(q)	
	}
}

function clean(){
	document.form.textview.value = ""
}

