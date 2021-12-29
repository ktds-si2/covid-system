<!-- Author : JHW -->
<template>
    <div>
        {{this.data}} page
        <login-form />
        Page Test Page
        <page-test />
    
    </div>
</template>

<script>
import LoginForm from './LoginForm.vue'
import PageTest from './PageTest.vue'

    export default {
        components: { LoginForm, PageTest },
        name:'Main',
        data() {
            return {
                data : 'Main',
            }
        }        
    }
</script>