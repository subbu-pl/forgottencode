import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { StartComponent } from './start/start.component';
import { BindingComponent } from './binding/binding.component';
import { NestedComponent } from './binding/nested.component';
import { IOModule } from './input-output/input-output.module';
import { DIModule } from './di/di.module';

@NgModule({
  declarations: [
    AppComponent,
    StartComponent,
    BindingComponent,
    NestedComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    IOModule,
    DIModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
