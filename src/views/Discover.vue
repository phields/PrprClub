<template>
  <div>
    <div id="discover-nav">
      <router-link to="/discover/home">发现</router-link>
      <router-link to="/discover/dynamics">动态</router-link>
      <router-link to="/discover/adoption">领养</router-link>
      <router-link to="/discover/about">关于我们</router-link>
      <span></span>
      <router-link to="/dashboard">仪表板</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>
