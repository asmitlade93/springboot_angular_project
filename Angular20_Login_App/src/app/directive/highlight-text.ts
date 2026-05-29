import { Directive, ElementRef, HostListener, inject, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appHighlightText]'
})
export class HighlightText {

  constructor() { }

  el = inject(ElementRef);
  renderer = inject(Renderer2);
  
  @HostListener('mouseenter')
  setYellow() {
    this.setColor('yellow');
  }

  @HostListener('mouseleave')
  removeColor() {
    this.setColor(null);
  }

  private setColor(color: string | null) {
    this.renderer.setStyle(this.el.nativeElement, 'color', color);
  }

}
