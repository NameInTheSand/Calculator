package com.example.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

	private lateinit var tvOne: TextView
	private lateinit var tvTwo: TextView
	private lateinit var tvThree: TextView
	private lateinit var tvFour: TextView
	private lateinit var tvFive: TextView
	private lateinit var tvSix: TextView
	private lateinit var tvSeven: TextView
	private lateinit var tvEight: TextView
	private lateinit var tvNine: TextView
	private lateinit var tvZero: TextView
	private lateinit var tvClearAll: TextView
	private lateinit var tvOpenBrackets: TextView
	private lateinit var tvCloseBrackets: TextView
	private lateinit var tvDivide: TextView
	private lateinit var tvMultiple: TextView
	private lateinit var tvPlus: TextView
	private lateinit var tvMinus: TextView
	private lateinit var tvDot: TextView
	private lateinit var tvClearLast: TextView
	private lateinit var tvEquals: TextView
	private lateinit var tvResults: TextView
	private lateinit var tvInput: TextView

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initViews()
		initListeners()
	}

	private fun initViews() {
		tvOne = findViewById(R.id.btn_one)
		tvTwo = findViewById(R.id.btn_two)
		tvThree = findViewById(R.id.btn_three)
		tvFour = findViewById(R.id.btn_four)
		tvFive = findViewById(R.id.btn_five)
		tvSix = findViewById(R.id.btn_six)
		tvSeven = findViewById(R.id.btn_seven)
		tvEight = findViewById(R.id.btn_eight)
		tvNine = findViewById(R.id.btn_nine)
		tvZero = findViewById(R.id.btn_zero)
		tvClearAll = findViewById(R.id.btn_ac)
		tvOpenBrackets = findViewById(R.id.btn_open_brackets)
		tvCloseBrackets = findViewById(R.id.btn_close_brackets)
		tvDivide = findViewById(R.id.btn_divide)
		tvMultiple = findViewById(R.id.btn_multiple)
		tvPlus = findViewById(R.id.btn_plus)
		tvMinus = findViewById(R.id.btn_minus)
		tvDot = findViewById(R.id.btn_dot)
		tvClearLast = findViewById(R.id.btn_delete_last)
		tvEquals = findViewById(R.id.btn_equals)
		tvResults = findViewById(R.id.tv_result)
		tvInput = findViewById(R.id.tv_input_view)
	}

	private fun initListeners() {
		tvOne.setOnClickListener { addInputNumber(1.toString()) }
		tvTwo.setOnClickListener { addInputNumber(2.toString()) }
		tvThree.setOnClickListener { addInputNumber(3.toString()) }
		tvFour.setOnClickListener { addInputNumber(4.toString()) }
		tvFive.setOnClickListener { addInputNumber(5.toString()) }
		tvSix.setOnClickListener { addInputNumber(6.toString()) }
		tvSeven.setOnClickListener { addInputNumber(7.toString()) }
		tvEight.setOnClickListener { addInputNumber(8.toString()) }
		tvNine.setOnClickListener { addInputNumber(9.toString()) }
		tvZero.setOnClickListener { addInputNumber(0.toString()) }
		tvOpenBrackets.setOnClickListener { addInputNumber("(") }
		tvCloseBrackets.setOnClickListener { addInputNumber(")") }
		tvDivide.setOnClickListener { addInputNumber("/") }
		tvMultiple.setOnClickListener { addInputNumber("*") }
		tvPlus.setOnClickListener { addInputNumber("+") }
		tvMinus.setOnClickListener { addInputNumber("-") }
		tvDot.setOnClickListener { addInputNumber(".") }

		tvClearAll.setOnClickListener {
			tvInput.text = ""
			tvResults.text = ""
		}

		tvClearLast.setOnClickListener {
			val tvInputText = tvInput.text.toString()
			if (tvInputText.isNotEmpty())
				tvInput.text = tvInputText.substring(0, tvInputText.length - 1)
		}

		tvEquals.setOnClickListener {
			try {
				val expression = ExpressionBuilder(tvInput.text.toString()).build()
				val result = expression.evaluate()

				tvResults.text = if (result == result.toLong().toDouble()) {
					result.toLong().toString()
				} else {
					result.toString()
				}

			} catch (e: Exception) {
				Log.e("ERROR_TAG", e.message.toString())
			}

		}
	}

	private fun addInputNumber(number: String) {
		tvInput.text = StringBuilder().append(tvInput.text.toString()).append(number)
	}
}