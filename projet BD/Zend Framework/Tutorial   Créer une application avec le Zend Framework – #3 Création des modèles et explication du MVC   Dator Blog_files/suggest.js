/*
Ajouter un vote à une suggestion
*/

$(function(){
	$('a.dovote').click(function(){
		var $this = $(this);
		var span = $this.parent().filter('span');
		
		$.ajax({
			type:"GET",
			url:"/wp-content/plugins/wp-suggest/ajax.php",
			data:{suggest_id: this.id.substring(8)},
			beforeSend:function(){
				span.fadeOut()
			},
			success:function(response){
				if(response.success==true){
					span.html(response.votes +' votes <br /><img src="/wp-content/plugins/wp-suggest/images/mercivote.png" alt="Merci !" />');
				}
				else {					
					alert("some error- "+response.error_txt);
				}
				
			},
			complete:function(){
				span.fadeIn()
			},
			dataType:"json"
			
		});
		return false;
	});
	/*
	Ajouter une suggestion
	*/
	$('.addSuggest').click(function(){
		if($('#text_suggest').val() == ""){
			alert('Votre suggestion est vide !');
			return false;
		}
		$.ajax({
			type:"POST",
			url:"/wp-content/plugins/wp-suggest/addajax.php",
			data:{suggest: true, text_suggest: $('#text_suggest').val()},
			success:function(response){
				if(response.success==true){
					$('#loadingSuggest').show();
					 $('#text_suggest').val('');
				}
				else {					
					alert("some error- "+response.error_txt);
				}
				
			},
			dataType:"json"
		});
		return false;
	});
});