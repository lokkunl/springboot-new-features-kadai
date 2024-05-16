 const stripe = Stripe('pk_test_51OwHic2La9ZPRkrZxI5IUIERdGRAKV2IMt8pIiO5Zbriz8Ny6kXuhdATQY7ZhugMWspcx9oZWhzRP6kmRTX2irAj00Ed4ydc4X');
 const paymentButton = document.querySelector('#paymentButton');
 
 paymentButton.addEventListener('click', () => {
   stripe.redirectToCheckout({
     sessionId: sessionId
   })
 });