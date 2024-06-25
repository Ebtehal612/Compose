package com.example.compose

import android.os.Bundle
import android.text.TextUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier= Modifier
                .padding(start= 10.dp,top=50.dp,end=20.dp),
                    verticalArrangement=Arrangement.spacedBy(20.dp)
            ) {
                val textValue= remember {
                    mutableStateOf(value = "")
                }
                val textValue1= remember {
                    mutableStateOf(value = "")
                }
                Text(text="Welcome Back", color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 25.sp)

                Text(text="We're excited to have you back, can't wait to see what you've been up to since you last logged in.\n", fontSize = 18.sp)
                OutlinedTextField(modifier= Modifier.fillMaxWidth(),value =  textValue.value, onValueChange ={text->
                    textValue.value= text
                } , label = { Text("Email") })
                OutlinedTextField(modifier= Modifier.fillMaxWidth(),value =  textValue1.value, onValueChange ={text->
                    textValue1.value= text
                } ,label = { Text("Password") })
                Row (

                    horizontalArrangement=Arrangement.spacedBy(140.dp),

                ){
                    val checkedState = remember { mutableStateOf(false) }
                    Row (horizontalArrangement = Arrangement.spacedBy(13.dp)){
                        Checkbox(checked =checkedState.value, onCheckedChange = {}, modifier = Modifier
                            .size(10.dp)
                            .padding(top = 9.dp, start = 10.dp))
                        Text(text="Remember me", )
                    }

                    Text(text="Forget Password?\n", color = Color.Blue, fontWeight = FontWeight.Bold, )
                }
                Button(onClick = { }, colors = ButtonDefaults.buttonColors(containerColor= Color.Blue), contentPadding = PaddingValues(start=170.dp,end=170.dp), ) {
                    Text(text = "Login",)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color.Gray
                    )
                    Text(
                        text = "Or sign in with",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = Color.Gray
                    )
                    Divider(
                        modifier = Modifier
                            .weight(1f)
                            .height(1.dp),
                        color = Color.Gray
                    )
                }
                Row (
                   modifier=Modifier.padding(horizontal =100.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ){
                    Image(painter = painterResource(id = R.drawable.google), contentDescription ="" , modifier = Modifier
                        .height(60.dp)
                        .width(50.dp))
                    Image(painter = painterResource(id = R.drawable.download), contentDescription ="" , modifier = Modifier
                        .height(60.dp)
                        .width(40.dp))
                    Image(painter = painterResource(id = R.drawable.apple), contentDescription ="" , modifier = Modifier
                        .height(55.dp)
                        .width(35.dp))
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        textAlign= TextAlign.Center,
                        text = buildAnnotatedString {
                            append("By logging, you agree to our ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("Terms & Conditions")
                            }
                            append(" and ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("PrivacyPolicy.\n")
                            }
                        }
                    )
                    Row {
                        Text(text = "Already have an account yet?")
                        Text(text = "Sign Up", color = Color.Blue)
                    }
                }
            }
        }
    }
}