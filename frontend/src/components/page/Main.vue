<!-- Author : JHW -->
<template>
    <div>
        {{this.data}} page
        <login-test />
    </div>
</template>

<script>
import LoginTest from './LoginTest.vue'

    export default {
        components: { LoginTest },
        name:'Main',
        data() {
            return {
                data : 'Main',
            }
        }        
    }

</script>