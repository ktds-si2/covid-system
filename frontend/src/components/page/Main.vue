<!-- Author : JHW -->
<template>
    <div>
        {{this.data}} page
        <login-test />
        Page Test Page
        <page-test />
    
    </div>
</template>

<script>
import LoginTest from './LoginTest.vue'
import PageTest from './PageTest.vue'

    export default {
        components: { LoginTest, PageTest },
        name:'Main',
        data() {
            return {
                data : 'Main',
            }
        }        
    }
</script>