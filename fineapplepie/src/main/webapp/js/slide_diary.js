//$(document).ready(function () {
	//slide();
//});

function slide() {

	var currentPosition = 0;
	var slideHeight = 200;
	var slides = $('.slide');
	var numberOfSlides = slides.length;

    // Remove scrollbar in JS
    $('#slideshow').css('overflow', 'hidden');

    // Wrap all .slides with #slideInner div
    //$('#slideshow').append($('<div/>').attr('id', 'slideInner').append(
	
	slides
      // Float left to display horizontally, readjust .slides width
      .css({
          'float': 'left',
          'height': slideHeight
      });

    // Set #slideInner width equal to total width of all slides
    $('#slideInner').css('height', slideHeight * numberOfSlides);

    // Insert controls in the DOM
    $('#l_btn')
      .append('<span class="control" id="leftControl"><img src="imgs/left.png"></span>');
    $('#r_btn')
        .append('<span class="control" id="rightControl"><img src="imgs/right.png"></span>');

    // Hide left arrow control on first load
    manageControls(currentPosition);

    // Create event listeners for .controls clicks
    $('.control')
      .bind('click', function () {
          // Determine new position
          currentPosition = ($(this).attr('id') == 'rightControl') ? currentPosition + 1 : currentPosition - 1;

          // Hide / show controls
          manageControls(currentPosition);
          // Move slideInner using margin-left
          $('#slideInner').animate({
              'marginTop': slideHeight * (-currentPosition)
          });
      });

    // manageControls: Hides and Shows controls depending on currentPosition
    function manageControls(position) {
        // Hide left arrow if position is first slide
        if (position == 0) { $('#leftControl').hide() } else { $('#leftControl').show() }
        // Hide right arrow if position is last slide
        if (position == numberOfSlides - 1) { $('#rightControl').hide() } else { $('#rightControl').show() }
    }
};