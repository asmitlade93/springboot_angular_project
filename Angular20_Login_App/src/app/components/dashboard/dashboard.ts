import { Component } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {

  isRightPanelOpen = false;

  toggleSidebar() {
    document.getElementById('sidebar-wrapper')?.classList.toggle('d-none');
  }

}
