// $(function() {
// 	var singleDropMenu = function(el, multiple) {
// 		this.el = el || {};
// 		this.multiple = multiple || false;

// 		// Variables privadas
// 		var links = this.el.find('.link');
// 		// Evento
// 		links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown)
// 	}

// 	singleDropMenu.prototype.dropdown = function(e) {
// 		var $el = e.data.el;
// 			$this = $(this),
// 			$next = $this.next();

// 		$next.slideToggle();
// 		$this.parent().toggleClass('open');

// 		if (!e.data.multiple) {
// 			$el.find('.sub-menu').not($next).slideUp().parent().removeClass('open');
// 		};
// 	}	

// 	var singleDropMenu = new singleDropMenu($('#singleDropMenu'), false);
// });