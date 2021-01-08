$(function(){
	
	
	$("#fin").change(function(){
		var fn=$("#fin").val();
		var db=$("#db").val();
		var d=db.split(":");
		var f=fn.split(":");
		if(f<d)
			{
			alert('Heure de fin doit etre > à heure debut');
			}
		
		
		
	});
	
	$("#note").keyup(function(){
		var nt=$("#note").val();
		
		if(nt<0 || nt>20)
			{
			alert('Entrer une note comprise entre 0 et 20');
			}
		
		
		
	});
	$("#coefficient").keyup(function(){
		var nt=$("#coefficient").val();
		
		if(nt<1)
			{
			alert('Entrer une valeure positive');
			}
		
		
		
	});
	
	
	
	
});