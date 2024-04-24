<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-display-middle">
<div style = "background-color: #6D9EEB; width:500px;" class="w3-container w3-round-xlarge">
	<div class="w3-container">
        
        <p>
        <label style = "color: #FAF9F8">Username:</label>
        <input type="text" id="userName" name="userName" class="w3-input w3-border w3-round userName" value="${sessionScope.username}" readonly>
        </p>
        
        <p>
        <label style = "color: #FAF9F8">New password:</label>
        <input class="w3-input w3-border w3-round pwd1User" type="password" id="pwd1User" name="pwd1User" placeholder="New Password" value="${user.pwd1}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Confirm new password:</label>
        <input class="w3-input w3-border w3-round pwd2User" type="password" id="pwd2User" name="pwd2User" placeholder="Confirm Password" value="${user.pwd2}" required data-parsley-equalto="#pwd2">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Email:</label>
        <input class="w3-input w3-border w3-round mailUser" type="email" id="mailUser" name="mailUser" placeholder="Email" value="${user.mail}" required>
        </p>
        
       <label class="w3-text-blue" for="genderUser"> Gender: </label>
  <br>
  
	<select class="genderUser" name="genderUser" id="genderUser">
		<option value="" disabled selected>Select gender</option>
		<option value="male">Male</option>
		<option value="female">Female</option>
		<option value="other">Other</option>
	</select><br><br>
  
  
  <label class="w3-text-blue" for="countryUser"> Country: </label><br>
  <select class="countryUser" name="countryUser" id="countryUser">
		<option value="" disabled selected>Select country</option>
      <optgroup label="North America">
          <option value="1">United States</option>
          <option value="2">United States Minor Outlying Islands</option>
          <option value="3">Canada</option>
          <option value="4">Mexico</option>
          <option value="5">Anguilla</option>
          <option value="6">Antigua and Barbuda</option>
          <option value="7">Aruba</option>
          <option value="8">Bahamas</option>
          <option value="9">Barbados</option>
          <option value="10">Belize</option>
          <option value="11">Bermuda</option>
          <option value="12">British Virgin Islands</option>
          <option value="13">Cayman Islands</option>
          <option value="14">Costa Rica</option>
          <option value="15">Cuba</option>
          <option value="16">Dominica</option>
          <option value="17">Dominican Republic</option>
          <option value="18">El Salvador</option>
          <option value="19">Grenada</option>
          <option value="20">Guadeloupe</option>
          <option value="21">Guatemala</option>
          <option value="22">Haiti</option>
          <option value="23">Honduras</option>
          <option value="24">Jamaica</option>
          <option value="25">Martinique</option>
          <option value="26">Montserrat</option>
          <option value="27">Netherlands Antilles</option>
          <option value="28">Nicaragua</option>
          <option value="29">Panama</option>
          <option value="30">Puerto Rico</option>
          <option value="31">Saint Kitts and Nevis</option>
          <option value="32">Saint Lucia</option>
          <option value="33">Saint Vincent and the Grenadines</option>
          <option value="34">Trinidad and Tobago</option>
          <option value="35">Turks and Caicos Islands</option>
          <option value="36">US Virgin Islands</option>
      </optgroup>
      <optgroup label="South America">
          <option value="37">Argentina</option>
          <option value="38">Bolivia</option>
          <option value="39">Brazil</option>
          <option value="40">Chile</option>
          <option value="41">Colombia</option>
          <option value="42">Ecuador</option>
          <option value="43">Falkland Islands (Malvinas)</option>
          <option value="44">French Guiana</option>
          <option value="45">Guyana</option>
          <option value="46">Paraguay</option>
          <option value="47">Peru</option>
          <option value="48">Suriname</option>
          <option value="49">Uruguay</option>
          <option value="50">Venezuela</option>
      </optgroup>
      <optgroup label="Europe">
          <option value="51">United Kingdom</option>
          <option value="52">Albania</option>
          <option value="53">Andorra</option>
          <option value="54">Austria</option>
          <option value="55">Belarus</option>
          <option value="56">Belgium</option>
          <option value="57">Bosnia and Herzegovina</option>
          <option value="58">Bulgaria</option>
          <option value="59">Croatia (Hrvatska)</option>
          <option value="60">Cyprus</option>
          <option value="61">Czech Republic</option>
          <option value="62">France</option>
          <option value="63">Gibraltar</option>
          <option value="64">Germany</option>
          <option value="65">Greece</option>
          <option value="66">Holy See (Vatican City State)</option>
          <option value="67">Hungary</option>
          <option value="68">Italy</option>
          <option value="69">Spain</option>
          <option value="70">Liechtenstein</option>
          <option value="71">Luxembourg</option>
          <option value="72">Macedonia</option>
          <option value="73">Malta</option>
          <option value="74">Moldova</option>
          <option value="75">Monaco</option>
          <option value="76">Montenegro</option>
          <option value="77">Netherlands</option>
          <option value="78">Poland</option>
          <option value="79">Portugal</option>
          <option value="80">Romania</option>
          <option value="81">San Marino</option>
          <option value="82">Serbia</option>
          <option value="83">Slovakia</option>
          <option value="84">Slovenia</option>
          <option value="85">Ukraine</option>
          <option value="86">Denmark</option>
          <option value="87">Estonia</option>
          <option value="88">Faroe Islands</option>
          <option value="89">Finland</option>
          <option value="90">Greenland</option>
          <option value="91">Iceland</option>
          <option value="92">Ireland</option>
          <option value="93">Latvia</option>
          <option value="94">Lithuania</option>
          <option value="95">Norway</option>
          <option value="96">Svalbard and Jan Mayen Islands</option>
          <option value="97">Sweden</option>
          <option value="98">Switzerland</option>
          <option value="99">Turkey</option>
      </optgroup>
      <optgroup label="Asia">
          <option value="100">Afghanistan</option>
          <option value="101">Armenia</option>
          <option value="102">Azerbaijan</option>
          <option value="103">Bahrain</option>
          <option value="104">Bangladesh</option>
          <option value="105">Bhutan</option>
          <option value="106">British Indian Ocean Territory</option>
          <option value="107">Brunei Darussalam</option>
          <option value="108">Cambodia</option>
          <option value="109">China</option>
          <option value="110">Christmas Island</option>
          <option value="111">Cocos (Keeling) Islands</option>
          <option value="112">Georgia</option>
          <option value="113">Hong Kong</option>
          <option value="114">India</option>
          <option value="115">Indonesia</option>
          <option value="116">Iran</option>
          <option value="117">Iraq</option>
          <option value="118">Israel</option>
          <option value="119">Japan</option>
          <option value="120">Jordan</option>
          <option value="121">Kazakhstan</option>
          <option value="122">Korea, Democratic People's Republic of</option>
          <option value="123">Korea, Republic of</option>
          <option value="124">Kuwait</option>
          <option value="125">Kyrgyzstan</option>
          <option value="126">Lao</option>
          <option value="127">Lebanon</option>
          <option value="128">Malaysia</option>
          <option value="129">Maldives</option>
          <option value="130">Mongolia</option>
          <option value="131">Myanmar (Burma)</option>
          <option value="132">Nepal</option>
          <option value="133">Oman</option>
          <option value="134">Pakistan</option>
          <option value="135">Philippines</option>
          <option value="136">Qatar</option>
          <option value="137">Russian Federation</option>
          <option value="138">Saudi Arabia</option>
          <option value="139">Singapore</option>
          <option value="140">Sri Lanka</option>
          <option value="141">Syria</option>
          <option value="142">Taiwan</option>
          <option value="143">Tajikistan</option>
          <option value="144">Thailand</option>
          <option value="145">East Timor</option>
          <option value="146">Turkmenistan</option>
          <option value="147">United Arab Emirates</option>
          <option value="148">Uzbekistan</option>
          <option value="149">Vietnam</option>
          <option value="150">Yemen</option>
      </optgroup>
      <optgroup label="Australia / Oceania">
          <option value="151">American Samoa</option>
          <option value="152">Australia</option>
          <option value="153">Cook Islands</option>
          <option value="154">Fiji</option>
          <option value="155">French Polynesia (Tahiti)</option>
          <option value="156">Guam</option>
          <option value="157">Kiribati</option>
          <option value="158">Marshall Islands</option>
          <option value="159">Micronesia, Federated States of</option>
          <option value="160">Nauru</option>
          <option value="161">New Caledonia</option>
          <option value="162">New Zealand</option>
          <option value="163">Niue</option>
          <option value="164">Northern Mariana Islands</option>
          <option value="165">Palau</option>
          <option value="166">Papua New Guinea</option>
          <option value="167">Pitcairn</option>
          <option value="168">Samoa</option>
          <option value="169">Solomon Islands</option>
          <option value="170">Tokelau</option>
          <option value="171">Tonga</option>
          <option value="172">Tuvalu</option>
          <option value="173">Vanuatu</option>
          <option value="174">Wallis and Futuna Islands</option>
      </optgroup>
      <optgroup label="Africa">
          <option value="175">Algeria</option>
          <option value="176">Angola</option>
          <option value="177">Benin</option>
          <option value="178">Botswana</option>
          <option value="179">Burkina Faso</option>
          <option value="180">Burundi</option>
          <option value="181">Cameroon</option>
          <option value="182">Cape Verde</option>
          <option value="183">Central African Republic</option>
          <option value="184">Chad</option>
          <option value="185">Comoros</option>
          <option value="186">Congo</option>
          <option value="187">Congo, the Democratic Republic of the</option>
          <option value="188">Dijibouti</option>
          <option value="189">Egypt</option>
          <option value="190">Equatorial Guinea</option>
          <option value="191">Eritrea</option>
          <option value="192">Ethiopia</option>
          <option value="193">Gabon</option>
          <option value="194">Gambia</option>
          <option value="195">Ghana</option>
          <option value="196">Guinea</option>
          <option value="197">Guinea-Bissau</option>
          <option value="198">Cote d'Ivoire (Ivory Coast)</option>
          <option value="199">Kenya</option>
          <option value="200">Lesotho</option>
          <option value="201">Liberia</option>
          <option value="202">Libya</option>
          <option value="203">Madagascar</option>
          <option value="204">Malawi</option>
          <option value="205">Mali</option>
          <option value="206">Mauritania</option>
          <option value="207">Mauritius</option>
          <option value="208">Mayotte</option>
          <option value="209">Morocco</option>
          <option value="210">Mozambique</option>
          <option value="211">Namibia</option>
          <option value="212">Niger</option>
          <option value="213">Nigeria</option>
          <option value="214">Reunion</option>
          <option value="215">Rwanda</option>
          <option value="216">Sao Tome and Principe</option>
          <option value="217">Saint Helena</option>
          <option value="218">Senegal</option>
          <option value="219">Seychelles</option>
          <option value="220">Sierra Leone</option>
          <option value="221">Somalia</option>
          <option value="222">South Africa</option>
          <option value="223">South Sudan</option>
          <option value="224">Sudan</option>
          <option value="225">Swaziland</option>
          <option value="226">Tanzania</option>
          <option value="227">Togo</option>
          <option value="228">Tunisia</option>
          <option value="229">Uganda</option>
          <option value="230">Western Sahara</option>
          <option value="231">Zambia</option>
          <option value="232">Zimbabwe</option>
      </optgroup>
      <option value="233">Antarctica</option>
      </select><br><br>
        
        <p>
        <label style = "color: #FAF9F8">BirthDate:</label>
        <input type="text" id="dateUser" name="dateUser" placeholder="DD/MM/YYYY" value="${user.date}" class="js-validate-dob dateUser" data-parsley-minimumage="13"
	data-parsley-minimumage-message="Applicant must be at least 13 years of age to apply" data-parsley-validdate="" 
	data-parsley-validdate-message="Please enter a valid date" data-parsley-pattern="/[0-9]\d*/"
	 data-parsley-pattern-message="Only numbers allowed" data-parsley-trigger="keyup" 
	 data-parsley-validation-threshold="0" required>
        </p>
        
        <div style= "text-align: center;">
        <h3>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class= "userEditing menu w3-panel w3-border w3-round-xlarge w3-btn" id="EditUserInfo">Save Changes</button>
        </h3>
        </div>
        
    
	</div>

</div>
</div>

</body>