import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import {ProfileComponent} from "./pages/profile/profile.component";
import {MessageComponent} from "./pages/message/message.component";
import {GroupComponent} from "./pages/group/group.component";
import {ChannelComponent} from "./pages/channel/channel.component";

const routes: Routes = [
  {path:'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'messages', component: MessageComponent},
  {path: 'groups', component: GroupComponent},
  {path: 'channels', component: ChannelComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
