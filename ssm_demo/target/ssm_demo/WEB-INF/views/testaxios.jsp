<!DOCTYPE html>
<html>
    <head>
        <title>vue-test</title>
        <script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
        <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>
  
<input type="text" id="hero" value="">
<div>2334</div>
  
<script>
    var a = document.getElementById('hero')
    var url = "http://localhost:8088/user/getJson"
    axios.get(url).then(function(response) {
        a.value = response.data[0].name;
    })
  
</script>
    </head>
</html>