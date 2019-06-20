<template>
  <div>
    <div id="dashboard-nav">
      <router-link to="/dashboard/me">我</router-link>
      <router-link to="/dashboard/works">作品</router-link>
      <router-link to="/dashboard/projects">企划</router-link>
      <router-link to="/dashboard/messages">消息</router-link>
      <router-link to="/dashboard/settings">设置</router-link>
      <span></span>
      <router-link to="/discover">发现</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>
