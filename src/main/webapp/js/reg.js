function abc()
{
	let sel = document.getElementById('sel');
	let val = sel.value;
	let div = document.getElementById('dept'); 
	if(val==2)
	{
		div.classList.remove('hide');
	}else{
		div.classList.add('hide');
	}
}