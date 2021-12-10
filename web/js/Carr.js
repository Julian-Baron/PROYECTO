/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
   $('tr #deleteitem').click(function(e){
      
       var elemento =$(this);
       var idproducto = elemento.parent().find('#idarticulo').text();
       $.ajax({
           url: 'borraritem',
           type: 'post',
           data:{idproducto:idproducto},
           
           success: function(r){
               elemento.parent().parent().remove();
               var elementostabla = $('#shop-table tr');
               if(elementostabla.length <= 1){
                   $('#cart-container').append("<span>No hay articulos en el carro</span>");
               }
               $('#txt-subtotal').text(r);
               $('#txt-total').text(r);
           }
       })
   });
   
   
   
});


