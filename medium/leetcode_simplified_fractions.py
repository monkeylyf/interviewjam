# https://leetcode.com/problems/simplified-fractions/

from typing import List

FRACTIONS = [[], [], ['1/2'], ['1/3', '2/3'], ['1/4', '3/4'], ['1/5', '2/5', '3/5', '4/5'], ['1/6', '5/6'], ['1/7', '2/7', '3/7', '4/7', '5/7', '6/7'], ['1/8', '3/8', '5/8', '7/8'], ['1/9', '2/9', '4/9', '5/9', '7/9', '8/9'], ['1/10', '3/10', '7/10', '9/10'], ['1/11', '2/11', '3/11', '4/11', '5/11', '6/11', '7/11', '8/11', '9/11', '10/11'], ['1/12', '5/12', '7/12', '11/12'], ['1/13', '2/13', '3/13', '4/13', '5/13', '6/13', '7/13', '8/13', '9/13', '10/13', '11/13', '12/13'], ['1/14', '3/14', '5/14', '9/14', '11/14', '13/14'], ['1/15', '2/15', '4/15', '7/15', '8/15', '11/15', '13/15', '14/15'], ['1/16', '3/16', '5/16', '7/16', '9/16', '11/16', '13/16', '15/16'], ['1/17', '2/17', '3/17', '4/17', '5/17', '6/17', '7/17', '8/17', '9/17', '10/17', '11/17', '12/17', '13/17', '14/17', '15/17', '16/17'], ['1/18', '5/18', '7/18', '11/18', '13/18', '17/18'], ['1/19', '2/19', '3/19', '4/19', '5/19', '6/19', '7/19', '8/19', '9/19', '10/19', '11/19', '12/19', '13/19', '14/19', '15/19', '16/19', '17/19', '18/19'], ['1/20', '3/20', '7/20', '9/20', '11/20', '13/20', '17/20', '19/20'], ['1/21', '2/21', '4/21', '5/21', '8/21', '10/21', '11/21', '13/21', '16/21', '17/21', '19/21', '20/21'], ['1/22', '3/22', '5/22', '7/22', '9/22', '13/22', '15/22', '17/22', '19/22', '21/22'], ['1/23', '2/23', '3/23', '4/23', '5/23', '6/23', '7/23', '8/23', '9/23', '10/23', '11/23', '12/23', '13/23', '14/23', '15/23', '16/23', '17/23', '18/23', '19/23', '20/23', '21/23', '22/23'], ['1/24', '5/24', '7/24', '11/24', '13/24', '17/24', '19/24', '23/24'], ['1/25', '2/25', '3/25', '4/25', '6/25', '7/25', '8/25', '9/25', '11/25', '12/25', '13/25', '14/25', '16/25', '17/25', '18/25', '19/25', '21/25', '22/25', '23/25', '24/25'], ['1/26', '3/26', '5/26', '7/26', '9/26', '11/26', '15/26', '17/26', '19/26', '21/26', '23/26', '25/26'], ['1/27', '2/27', '4/27', '5/27', '7/27', '8/27', '10/27', '11/27', '13/27', '14/27', '16/27', '17/27', '19/27', '20/27', '22/27', '23/27', '25/27', '26/27'], ['1/28', '3/28', '5/28', '9/28', '11/28', '13/28', '15/28', '17/28', '19/28', '23/28', '25/28', '27/28'], ['1/29', '2/29', '3/29', '4/29', '5/29', '6/29', '7/29', '8/29', '9/29', '10/29', '11/29', '12/29', '13/29', '14/29', '15/29', '16/29', '17/29', '18/29', '19/29', '20/29', '21/29', '22/29', '23/29', '24/29', '25/29', '26/29', '27/29', '28/29'], ['1/30', '7/30', '11/30', '13/30', '17/30', '19/30', '23/30', '29/30'], ['1/31', '2/31', '3/31', '4/31', '5/31', '6/31', '7/31', '8/31', '9/31', '10/31', '11/31', '12/31', '13/31', '14/31', '15/31', '16/31', '17/31', '18/31', '19/31', '20/31', '21/31', '22/31', '23/31', '24/31', '25/31', '26/31', '27/31', '28/31', '29/31', '30/31'], ['1/32', '3/32', '5/32', '7/32', '9/32', '11/32', '13/32', '15/32', '17/32', '19/32', '21/32', '23/32', '25/32', '27/32', '29/32', '31/32'], ['1/33', '2/33', '4/33', '5/33', '7/33', '8/33', '10/33', '13/33', '14/33', '16/33', '17/33', '19/33', '20/33', '23/33', '25/33', '26/33', '28/33', '29/33', '31/33', '32/33'], ['1/34', '3/34', '5/34', '7/34', '9/34', '11/34', '13/34', '15/34', '19/34', '21/34', '23/34', '25/34', '27/34', '29/34', '31/34', '33/34'], ['1/35', '2/35', '3/35', '4/35', '6/35', '8/35', '9/35', '11/35', '12/35', '13/35', '16/35', '17/35', '18/35', '19/35', '22/35', '23/35', '24/35', '26/35', '27/35', '29/35', '31/35', '32/35', '33/35', '34/35'], ['1/36', '5/36', '7/36', '11/36', '13/36', '17/36', '19/36', '23/36', '25/36', '29/36', '31/36', '35/36'], ['1/37', '2/37', '3/37', '4/37', '5/37', '6/37', '7/37', '8/37', '9/37', '10/37', '11/37', '12/37', '13/37', '14/37', '15/37', '16/37', '17/37', '18/37', '19/37', '20/37', '21/37', '22/37', '23/37', '24/37', '25/37', '26/37', '27/37', '28/37', '29/37', '30/37', '31/37', '32/37', '33/37', '34/37', '35/37', '36/37'], ['1/38', '3/38', '5/38', '7/38', '9/38', '11/38', '13/38', '15/38', '17/38', '21/38', '23/38', '25/38', '27/38', '29/38', '31/38', '33/38', '35/38', '37/38'], ['1/39', '2/39', '4/39', '5/39', '7/39', '8/39', '10/39', '11/39', '14/39', '16/39', '17/39', '19/39', '20/39', '22/39', '23/39', '25/39', '28/39', '29/39', '31/39', '32/39', '34/39', '35/39', '37/39', '38/39'], ['1/40', '3/40', '7/40', '9/40', '11/40', '13/40', '17/40', '19/40', '21/40', '23/40', '27/40', '29/40', '31/40', '33/40', '37/40', '39/40'], ['1/41', '2/41', '3/41', '4/41', '5/41', '6/41', '7/41', '8/41', '9/41', '10/41', '11/41', '12/41', '13/41', '14/41', '15/41', '16/41', '17/41', '18/41', '19/41', '20/41', '21/41', '22/41', '23/41', '24/41', '25/41', '26/41', '27/41', '28/41', '29/41', '30/41', '31/41', '32/41', '33/41', '34/41', '35/41', '36/41', '37/41', '38/41', '39/41', '40/41'], ['1/42', '5/42', '11/42', '13/42', '17/42', '19/42', '23/42', '25/42', '29/42', '31/42', '37/42', '41/42'], ['1/43', '2/43', '3/43', '4/43', '5/43', '6/43', '7/43', '8/43', '9/43', '10/43', '11/43', '12/43', '13/43', '14/43', '15/43', '16/43', '17/43', '18/43', '19/43', '20/43', '21/43', '22/43', '23/43', '24/43', '25/43', '26/43', '27/43', '28/43', '29/43', '30/43', '31/43', '32/43', '33/43', '34/43', '35/43', '36/43', '37/43', '38/43', '39/43', '40/43', '41/43', '42/43'], ['1/44', '3/44', '5/44', '7/44', '9/44', '13/44', '15/44', '17/44', '19/44', '21/44', '23/44', '25/44', '27/44', '29/44', '31/44', '35/44', '37/44', '39/44', '41/44', '43/44'], ['1/45', '2/45', '4/45', '7/45', '8/45', '11/45', '13/45', '14/45', '16/45', '17/45', '19/45', '22/45', '23/45', '26/45', '28/45', '29/45', '31/45', '32/45', '34/45', '37/45', '38/45', '41/45', '43/45', '44/45'], ['1/46', '3/46', '5/46', '7/46', '9/46', '11/46', '13/46', '15/46', '17/46', '19/46', '21/46', '25/46', '27/46', '29/46', '31/46', '33/46', '35/46', '37/46', '39/46', '41/46', '43/46', '45/46'], ['1/47', '2/47', '3/47', '4/47', '5/47', '6/47', '7/47', '8/47', '9/47', '10/47', '11/47', '12/47', '13/47', '14/47', '15/47', '16/47', '17/47', '18/47', '19/47', '20/47', '21/47', '22/47', '23/47', '24/47', '25/47', '26/47', '27/47', '28/47', '29/47', '30/47', '31/47', '32/47', '33/47', '34/47', '35/47', '36/47', '37/47', '38/47', '39/47', '40/47', '41/47', '42/47', '43/47', '44/47', '45/47', '46/47'], ['1/48', '5/48', '7/48', '11/48', '13/48', '17/48', '19/48', '23/48', '25/48', '29/48', '31/48', '35/48', '37/48', '41/48', '43/48', '47/48'], ['1/49', '2/49', '3/49', '4/49', '5/49', '6/49', '8/49', '9/49', '10/49', '11/49', '12/49', '13/49', '15/49', '16/49', '17/49', '18/49', '19/49', '20/49', '22/49', '23/49', '24/49', '25/49', '26/49', '27/49', '29/49', '30/49', '31/49', '32/49', '33/49', '34/49', '36/49', '37/49', '38/49', '39/49', '40/49', '41/49', '43/49', '44/49', '45/49', '46/49', '47/49', '48/49'], ['1/50', '3/50', '7/50', '9/50', '11/50', '13/50', '17/50', '19/50', '21/50', '23/50', '27/50', '29/50', '31/50', '33/50', '37/50', '39/50', '41/50', '43/50', '47/50', '49/50'], ['1/51', '2/51', '4/51', '5/51', '7/51', '8/51', '10/51', '11/51', '13/51', '14/51', '16/51', '19/51', '20/51', '22/51', '23/51', '25/51', '26/51', '28/51', '29/51', '31/51', '32/51', '35/51', '37/51', '38/51', '40/51', '41/51', '43/51', '44/51', '46/51', '47/51', '49/51', '50/51'], ['1/52', '3/52', '5/52', '7/52', '9/52', '11/52', '15/52', '17/52', '19/52', '21/52', '23/52', '25/52', '27/52', '29/52', '31/52', '33/52', '35/52', '37/52', '41/52', '43/52', '45/52', '47/52', '49/52', '51/52'], ['1/53', '2/53', '3/53', '4/53', '5/53', '6/53', '7/53', '8/53', '9/53', '10/53', '11/53', '12/53', '13/53', '14/53', '15/53', '16/53', '17/53', '18/53', '19/53', '20/53', '21/53', '22/53', '23/53', '24/53', '25/53', '26/53', '27/53', '28/53', '29/53', '30/53', '31/53', '32/53', '33/53', '34/53', '35/53', '36/53', '37/53', '38/53', '39/53', '40/53', '41/53', '42/53', '43/53', '44/53', '45/53', '46/53', '47/53', '48/53', '49/53', '50/53', '51/53', '52/53'], ['1/54', '5/54', '7/54', '11/54', '13/54', '17/54', '19/54', '23/54', '25/54', '29/54', '31/54', '35/54', '37/54', '41/54', '43/54', '47/54', '49/54', '53/54'], ['1/55', '2/55', '3/55', '4/55', '6/55', '7/55', '8/55', '9/55', '12/55', '13/55', '14/55', '16/55', '17/55', '18/55', '19/55', '21/55', '23/55', '24/55', '26/55', '27/55', '28/55', '29/55', '31/55', '32/55', '34/55', '36/55', '37/55', '38/55', '39/55', '41/55', '42/55', '43/55', '46/55', '47/55', '48/55', '49/55', '51/55', '52/55', '53/55', '54/55'], ['1/56', '3/56', '5/56', '9/56', '11/56', '13/56', '15/56', '17/56', '19/56', '23/56', '25/56', '27/56', '29/56', '31/56', '33/56', '37/56', '39/56', '41/56', '43/56', '45/56', '47/56', '51/56', '53/56', '55/56'], ['1/57', '2/57', '4/57', '5/57', '7/57', '8/57', '10/57', '11/57', '13/57', '14/57', '16/57', '17/57', '20/57', '22/57', '23/57', '25/57', '26/57', '28/57', '29/57', '31/57', '32/57', '34/57', '35/57', '37/57', '40/57', '41/57', '43/57', '44/57', '46/57', '47/57', '49/57', '50/57', '52/57', '53/57', '55/57', '56/57'], ['1/58', '3/58', '5/58', '7/58', '9/58', '11/58', '13/58', '15/58', '17/58', '19/58', '21/58', '23/58', '25/58', '27/58', '31/58', '33/58', '35/58', '37/58', '39/58', '41/58', '43/58', '45/58', '47/58', '49/58', '51/58', '53/58', '55/58', '57/58'], ['1/59', '2/59', '3/59', '4/59', '5/59', '6/59', '7/59', '8/59', '9/59', '10/59', '11/59', '12/59', '13/59', '14/59', '15/59', '16/59', '17/59', '18/59', '19/59', '20/59', '21/59', '22/59', '23/59', '24/59', '25/59', '26/59', '27/59', '28/59', '29/59', '30/59', '31/59', '32/59', '33/59', '34/59', '35/59', '36/59', '37/59', '38/59', '39/59', '40/59', '41/59', '42/59', '43/59', '44/59', '45/59', '46/59', '47/59', '48/59', '49/59', '50/59', '51/59', '52/59', '53/59', '54/59', '55/59', '56/59', '57/59', '58/59'], ['1/60', '7/60', '11/60', '13/60', '17/60', '19/60', '23/60', '29/60', '31/60', '37/60', '41/60', '43/60', '47/60', '49/60', '53/60', '59/60'], ['1/61', '2/61', '3/61', '4/61', '5/61', '6/61', '7/61', '8/61', '9/61', '10/61', '11/61', '12/61', '13/61', '14/61', '15/61', '16/61', '17/61', '18/61', '19/61', '20/61', '21/61', '22/61', '23/61', '24/61', '25/61', '26/61', '27/61', '28/61', '29/61', '30/61', '31/61', '32/61', '33/61', '34/61', '35/61', '36/61', '37/61', '38/61', '39/61', '40/61', '41/61', '42/61', '43/61', '44/61', '45/61', '46/61', '47/61', '48/61', '49/61', '50/61', '51/61', '52/61', '53/61', '54/61', '55/61', '56/61', '57/61', '58/61', '59/61', '60/61'], ['1/62', '3/62', '5/62', '7/62', '9/62', '11/62', '13/62', '15/62', '17/62', '19/62', '21/62', '23/62', '25/62', '27/62', '29/62', '33/62', '35/62', '37/62', '39/62', '41/62', '43/62', '45/62', '47/62', '49/62', '51/62', '53/62', '55/62', '57/62', '59/62', '61/62'], ['1/63', '2/63', '4/63', '5/63', '8/63', '10/63', '11/63', '13/63', '16/63', '17/63', '19/63', '20/63', '22/63', '23/63', '25/63', '26/63', '29/63', '31/63', '32/63', '34/63', '37/63', '38/63', '40/63', '41/63', '43/63', '44/63', '46/63', '47/63', '50/63', '52/63', '53/63', '55/63', '58/63', '59/63', '61/63', '62/63'], ['1/64', '3/64', '5/64', '7/64', '9/64', '11/64', '13/64', '15/64', '17/64', '19/64', '21/64', '23/64', '25/64', '27/64', '29/64', '31/64', '33/64', '35/64', '37/64', '39/64', '41/64', '43/64', '45/64', '47/64', '49/64', '51/64', '53/64', '55/64', '57/64', '59/64', '61/64', '63/64'], ['1/65', '2/65', '3/65', '4/65', '6/65', '7/65', '8/65', '9/65', '11/65', '12/65', '14/65', '16/65', '17/65', '18/65', '19/65', '21/65', '22/65', '23/65', '24/65', '27/65', '28/65', '29/65', '31/65', '32/65', '33/65', '34/65', '36/65', '37/65', '38/65', '41/65', '42/65', '43/65', '44/65', '46/65', '47/65', '48/65', '49/65', '51/65', '53/65', '54/65', '56/65', '57/65', '58/65', '59/65', '61/65', '62/65', '63/65', '64/65'], ['1/66', '5/66', '7/66', '13/66', '17/66', '19/66', '23/66', '25/66', '29/66', '31/66', '35/66', '37/66', '41/66', '43/66', '47/66', '49/66', '53/66', '59/66', '61/66', '65/66'], ['1/67', '2/67', '3/67', '4/67', '5/67', '6/67', '7/67', '8/67', '9/67', '10/67', '11/67', '12/67', '13/67', '14/67', '15/67', '16/67', '17/67', '18/67', '19/67', '20/67', '21/67', '22/67', '23/67', '24/67', '25/67', '26/67', '27/67', '28/67', '29/67', '30/67', '31/67', '32/67', '33/67', '34/67', '35/67', '36/67', '37/67', '38/67', '39/67', '40/67', '41/67', '42/67', '43/67', '44/67', '45/67', '46/67', '47/67', '48/67', '49/67', '50/67', '51/67', '52/67', '53/67', '54/67', '55/67', '56/67', '57/67', '58/67', '59/67', '60/67', '61/67', '62/67', '63/67', '64/67', '65/67', '66/67'], ['1/68', '3/68', '5/68', '7/68', '9/68', '11/68', '13/68', '15/68', '19/68', '21/68', '23/68', '25/68', '27/68', '29/68', '31/68', '33/68', '35/68', '37/68', '39/68', '41/68', '43/68', '45/68', '47/68', '49/68', '53/68', '55/68', '57/68', '59/68', '61/68', '63/68', '65/68', '67/68'], ['1/69', '2/69', '4/69', '5/69', '7/69', '8/69', '10/69', '11/69', '13/69', '14/69', '16/69', '17/69', '19/69', '20/69', '22/69', '25/69', '26/69', '28/69', '29/69', '31/69', '32/69', '34/69', '35/69', '37/69', '38/69', '40/69', '41/69', '43/69', '44/69', '47/69', '49/69', '50/69', '52/69', '53/69', '55/69', '56/69', '58/69', '59/69', '61/69', '62/69', '64/69', '65/69', '67/69', '68/69'], ['1/70', '3/70', '9/70', '11/70', '13/70', '17/70', '19/70', '23/70', '27/70', '29/70', '31/70', '33/70', '37/70', '39/70', '41/70', '43/70', '47/70', '51/70', '53/70', '57/70', '59/70', '61/70', '67/70', '69/70'], ['1/71', '2/71', '3/71', '4/71', '5/71', '6/71', '7/71', '8/71', '9/71', '10/71', '11/71', '12/71', '13/71', '14/71', '15/71', '16/71', '17/71', '18/71', '19/71', '20/71', '21/71', '22/71', '23/71', '24/71', '25/71', '26/71', '27/71', '28/71', '29/71', '30/71', '31/71', '32/71', '33/71', '34/71', '35/71', '36/71', '37/71', '38/71', '39/71', '40/71', '41/71', '42/71', '43/71', '44/71', '45/71', '46/71', '47/71', '48/71', '49/71', '50/71', '51/71', '52/71', '53/71', '54/71', '55/71', '56/71', '57/71', '58/71', '59/71', '60/71', '61/71', '62/71', '63/71', '64/71', '65/71', '66/71', '67/71', '68/71', '69/71', '70/71'], ['1/72', '5/72', '7/72', '11/72', '13/72', '17/72', '19/72', '23/72', '25/72', '29/72', '31/72', '35/72', '37/72', '41/72', '43/72', '47/72', '49/72', '53/72', '55/72', '59/72', '61/72', '65/72', '67/72', '71/72'], ['1/73', '2/73', '3/73', '4/73', '5/73', '6/73', '7/73', '8/73', '9/73', '10/73', '11/73', '12/73', '13/73', '14/73', '15/73', '16/73', '17/73', '18/73', '19/73', '20/73', '21/73', '22/73', '23/73', '24/73', '25/73', '26/73', '27/73', '28/73', '29/73', '30/73', '31/73', '32/73', '33/73', '34/73', '35/73', '36/73', '37/73', '38/73', '39/73', '40/73', '41/73', '42/73', '43/73', '44/73', '45/73', '46/73', '47/73', '48/73', '49/73', '50/73', '51/73', '52/73', '53/73', '54/73', '55/73', '56/73', '57/73', '58/73', '59/73', '60/73', '61/73', '62/73', '63/73', '64/73', '65/73', '66/73', '67/73', '68/73', '69/73', '70/73', '71/73', '72/73'], ['1/74', '3/74', '5/74', '7/74', '9/74', '11/74', '13/74', '15/74', '17/74', '19/74', '21/74', '23/74', '25/74', '27/74', '29/74', '31/74', '33/74', '35/74', '39/74', '41/74', '43/74', '45/74', '47/74', '49/74', '51/74', '53/74', '55/74', '57/74', '59/74', '61/74', '63/74', '65/74', '67/74', '69/74', '71/74', '73/74'], ['1/75', '2/75', '4/75', '7/75', '8/75', '11/75', '13/75', '14/75', '16/75', '17/75', '19/75', '22/75', '23/75', '26/75', '28/75', '29/75', '31/75', '32/75', '34/75', '37/75', '38/75', '41/75', '43/75', '44/75', '46/75', '47/75', '49/75', '52/75', '53/75', '56/75', '58/75', '59/75', '61/75', '62/75', '64/75', '67/75', '68/75', '71/75', '73/75', '74/75'], ['1/76', '3/76', '5/76', '7/76', '9/76', '11/76', '13/76', '15/76', '17/76', '21/76', '23/76', '25/76', '27/76', '29/76', '31/76', '33/76', '35/76', '37/76', '39/76', '41/76', '43/76', '45/76', '47/76', '49/76', '51/76', '53/76', '55/76', '59/76', '61/76', '63/76', '65/76', '67/76', '69/76', '71/76', '73/76', '75/76'], ['1/77', '2/77', '3/77', '4/77', '5/77', '6/77', '8/77', '9/77', '10/77', '12/77', '13/77', '15/77', '16/77', '17/77', '18/77', '19/77', '20/77', '23/77', '24/77', '25/77', '26/77', '27/77', '29/77', '30/77', '31/77', '32/77', '34/77', '36/77', '37/77', '38/77', '39/77', '40/77', '41/77', '43/77', '45/77', '46/77', '47/77', '48/77', '50/77', '51/77', '52/77', '53/77', '54/77', '57/77', '58/77', '59/77', '60/77', '61/77', '62/77', '64/77', '65/77', '67/77', '68/77', '69/77', '71/77', '72/77', '73/77', '74/77', '75/77', '76/77'], ['1/78', '5/78', '7/78', '11/78', '17/78', '19/78', '23/78', '25/78', '29/78', '31/78', '35/78', '37/78', '41/78', '43/78', '47/78', '49/78', '53/78', '55/78', '59/78', '61/78', '67/78', '71/78', '73/78', '77/78'], ['1/79', '2/79', '3/79', '4/79', '5/79', '6/79', '7/79', '8/79', '9/79', '10/79', '11/79', '12/79', '13/79', '14/79', '15/79', '16/79', '17/79', '18/79', '19/79', '20/79', '21/79', '22/79', '23/79', '24/79', '25/79', '26/79', '27/79', '28/79', '29/79', '30/79', '31/79', '32/79', '33/79', '34/79', '35/79', '36/79', '37/79', '38/79', '39/79', '40/79', '41/79', '42/79', '43/79', '44/79', '45/79', '46/79', '47/79', '48/79', '49/79', '50/79', '51/79', '52/79', '53/79', '54/79', '55/79', '56/79', '57/79', '58/79', '59/79', '60/79', '61/79', '62/79', '63/79', '64/79', '65/79', '66/79', '67/79', '68/79', '69/79', '70/79', '71/79', '72/79', '73/79', '74/79', '75/79', '76/79', '77/79', '78/79'], ['1/80', '3/80', '7/80', '9/80', '11/80', '13/80', '17/80', '19/80', '21/80', '23/80', '27/80', '29/80', '31/80', '33/80', '37/80', '39/80', '41/80', '43/80', '47/80', '49/80', '51/80', '53/80', '57/80', '59/80', '61/80', '63/80', '67/80', '69/80', '71/80', '73/80', '77/80', '79/80'], ['1/81', '2/81', '4/81', '5/81', '7/81', '8/81', '10/81', '11/81', '13/81', '14/81', '16/81', '17/81', '19/81', '20/81', '22/81', '23/81', '25/81', '26/81', '28/81', '29/81', '31/81', '32/81', '34/81', '35/81', '37/81', '38/81', '40/81', '41/81', '43/81', '44/81', '46/81', '47/81', '49/81', '50/81', '52/81', '53/81', '55/81', '56/81', '58/81', '59/81', '61/81', '62/81', '64/81', '65/81', '67/81', '68/81', '70/81', '71/81', '73/81', '74/81', '76/81', '77/81', '79/81', '80/81'], ['1/82', '3/82', '5/82', '7/82', '9/82', '11/82', '13/82', '15/82', '17/82', '19/82', '21/82', '23/82', '25/82', '27/82', '29/82', '31/82', '33/82', '35/82', '37/82', '39/82', '43/82', '45/82', '47/82', '49/82', '51/82', '53/82', '55/82', '57/82', '59/82', '61/82', '63/82', '65/82', '67/82', '69/82', '71/82', '73/82', '75/82', '77/82', '79/82', '81/82'], ['1/83', '2/83', '3/83', '4/83', '5/83', '6/83', '7/83', '8/83', '9/83', '10/83', '11/83', '12/83', '13/83', '14/83', '15/83', '16/83', '17/83', '18/83', '19/83', '20/83', '21/83', '22/83', '23/83', '24/83', '25/83', '26/83', '27/83', '28/83', '29/83', '30/83', '31/83', '32/83', '33/83', '34/83', '35/83', '36/83', '37/83', '38/83', '39/83', '40/83', '41/83', '42/83', '43/83', '44/83', '45/83', '46/83', '47/83', '48/83', '49/83', '50/83', '51/83', '52/83', '53/83', '54/83', '55/83', '56/83', '57/83', '58/83', '59/83', '60/83', '61/83', '62/83', '63/83', '64/83', '65/83', '66/83', '67/83', '68/83', '69/83', '70/83', '71/83', '72/83', '73/83', '74/83', '75/83', '76/83', '77/83', '78/83', '79/83', '80/83', '81/83', '82/83'], ['1/84', '5/84', '11/84', '13/84', '17/84', '19/84', '23/84', '25/84', '29/84', '31/84', '37/84', '41/84', '43/84', '47/84', '53/84', '55/84', '59/84', '61/84', '65/84', '67/84', '71/84', '73/84', '79/84', '83/84'], ['1/85', '2/85', '3/85', '4/85', '6/85', '7/85', '8/85', '9/85', '11/85', '12/85', '13/85', '14/85', '16/85', '18/85', '19/85', '21/85', '22/85', '23/85', '24/85', '26/85', '27/85', '28/85', '29/85', '31/85', '32/85', '33/85', '36/85', '37/85', '38/85', '39/85', '41/85', '42/85', '43/85', '44/85', '46/85', '47/85', '48/85', '49/85', '52/85', '53/85', '54/85', '56/85', '57/85', '58/85', '59/85', '61/85', '62/85', '63/85', '64/85', '66/85', '67/85', '69/85', '71/85', '72/85', '73/85', '74/85', '76/85', '77/85', '78/85', '79/85', '81/85', '82/85', '83/85', '84/85'], ['1/86', '3/86', '5/86', '7/86', '9/86', '11/86', '13/86', '15/86', '17/86', '19/86', '21/86', '23/86', '25/86', '27/86', '29/86', '31/86', '33/86', '35/86', '37/86', '39/86', '41/86', '45/86', '47/86', '49/86', '51/86', '53/86', '55/86', '57/86', '59/86', '61/86', '63/86', '65/86', '67/86', '69/86', '71/86', '73/86', '75/86', '77/86', '79/86', '81/86', '83/86', '85/86'], ['1/87', '2/87', '4/87', '5/87', '7/87', '8/87', '10/87', '11/87', '13/87', '14/87', '16/87', '17/87', '19/87', '20/87', '22/87', '23/87', '25/87', '26/87', '28/87', '31/87', '32/87', '34/87', '35/87', '37/87', '38/87', '40/87', '41/87', '43/87', '44/87', '46/87', '47/87', '49/87', '50/87', '52/87', '53/87', '55/87', '56/87', '59/87', '61/87', '62/87', '64/87', '65/87', '67/87', '68/87', '70/87', '71/87', '73/87', '74/87', '76/87', '77/87', '79/87', '80/87', '82/87', '83/87', '85/87', '86/87'], ['1/88', '3/88', '5/88', '7/88', '9/88', '13/88', '15/88', '17/88', '19/88', '21/88', '23/88', '25/88', '27/88', '29/88', '31/88', '35/88', '37/88', '39/88', '41/88', '43/88', '45/88', '47/88', '49/88', '51/88', '53/88', '57/88', '59/88', '61/88', '63/88', '65/88', '67/88', '69/88', '71/88', '73/88', '75/88', '79/88', '81/88', '83/88', '85/88', '87/88'], ['1/89', '2/89', '3/89', '4/89', '5/89', '6/89', '7/89', '8/89', '9/89', '10/89', '11/89', '12/89', '13/89', '14/89', '15/89', '16/89', '17/89', '18/89', '19/89', '20/89', '21/89', '22/89', '23/89', '24/89', '25/89', '26/89', '27/89', '28/89', '29/89', '30/89', '31/89', '32/89', '33/89', '34/89', '35/89', '36/89', '37/89', '38/89', '39/89', '40/89', '41/89', '42/89', '43/89', '44/89', '45/89', '46/89', '47/89', '48/89', '49/89', '50/89', '51/89', '52/89', '53/89', '54/89', '55/89', '56/89', '57/89', '58/89', '59/89', '60/89', '61/89', '62/89', '63/89', '64/89', '65/89', '66/89', '67/89', '68/89', '69/89', '70/89', '71/89', '72/89', '73/89', '74/89', '75/89', '76/89', '77/89', '78/89', '79/89', '80/89', '81/89', '82/89', '83/89', '84/89', '85/89', '86/89', '87/89', '88/89'], ['1/90', '7/90', '11/90', '13/90', '17/90', '19/90', '23/90', '29/90', '31/90', '37/90', '41/90', '43/90', '47/90', '49/90', '53/90', '59/90', '61/90', '67/90', '71/90', '73/90', '77/90', '79/90', '83/90', '89/90'], ['1/91', '2/91', '3/91', '4/91', '5/91', '6/91', '8/91', '9/91', '10/91', '11/91', '12/91', '15/91', '16/91', '17/91', '18/91', '19/91', '20/91', '22/91', '23/91', '24/91', '25/91', '27/91', '29/91', '30/91', '31/91', '32/91', '33/91', '34/91', '36/91', '37/91', '38/91', '40/91', '41/91', '43/91', '44/91', '45/91', '46/91', '47/91', '48/91', '50/91', '51/91', '53/91', '54/91', '55/91', '57/91', '58/91', '59/91', '60/91', '61/91', '62/91', '64/91', '66/91', '67/91', '68/91', '69/91', '71/91', '72/91', '73/91', '74/91', '75/91', '76/91', '79/91', '80/91', '81/91', '82/91', '83/91', '85/91', '86/91', '87/91', '88/91', '89/91', '90/91'], ['1/92', '3/92', '5/92', '7/92', '9/92', '11/92', '13/92', '15/92', '17/92', '19/92', '21/92', '25/92', '27/92', '29/92', '31/92', '33/92', '35/92', '37/92', '39/92', '41/92', '43/92', '45/92', '47/92', '49/92', '51/92', '53/92', '55/92', '57/92', '59/92', '61/92', '63/92', '65/92', '67/92', '71/92', '73/92', '75/92', '77/92', '79/92', '81/92', '83/92', '85/92', '87/92', '89/92', '91/92'], ['1/93', '2/93', '4/93', '5/93', '7/93', '8/93', '10/93', '11/93', '13/93', '14/93', '16/93', '17/93', '19/93', '20/93', '22/93', '23/93', '25/93', '26/93', '28/93', '29/93', '32/93', '34/93', '35/93', '37/93', '38/93', '40/93', '41/93', '43/93', '44/93', '46/93', '47/93', '49/93', '50/93', '52/93', '53/93', '55/93', '56/93', '58/93', '59/93', '61/93', '64/93', '65/93', '67/93', '68/93', '70/93', '71/93', '73/93', '74/93', '76/93', '77/93', '79/93', '80/93', '82/93', '83/93', '85/93', '86/93', '88/93', '89/93', '91/93', '92/93'], ['1/94', '3/94', '5/94', '7/94', '9/94', '11/94', '13/94', '15/94', '17/94', '19/94', '21/94', '23/94', '25/94', '27/94', '29/94', '31/94', '33/94', '35/94', '37/94', '39/94', '41/94', '43/94', '45/94', '49/94', '51/94', '53/94', '55/94', '57/94', '59/94', '61/94', '63/94', '65/94', '67/94', '69/94', '71/94', '73/94', '75/94', '77/94', '79/94', '81/94', '83/94', '85/94', '87/94', '89/94', '91/94', '93/94'], ['1/95', '2/95', '3/95', '4/95', '6/95', '7/95', '8/95', '9/95', '11/95', '12/95', '13/95', '14/95', '16/95', '17/95', '18/95', '21/95', '22/95', '23/95', '24/95', '26/95', '27/95', '28/95', '29/95', '31/95', '32/95', '33/95', '34/95', '36/95', '37/95', '39/95', '41/95', '42/95', '43/95', '44/95', '46/95', '47/95', '48/95', '49/95', '51/95', '52/95', '53/95', '54/95', '56/95', '58/95', '59/95', '61/95', '62/95', '63/95', '64/95', '66/95', '67/95', '68/95', '69/95', '71/95', '72/95', '73/95', '74/95', '77/95', '78/95', '79/95', '81/95', '82/95', '83/95', '84/95', '86/95', '87/95', '88/95', '89/95', '91/95', '92/95', '93/95', '94/95'], ['1/96', '5/96', '7/96', '11/96', '13/96', '17/96', '19/96', '23/96', '25/96', '29/96', '31/96', '35/96', '37/96', '41/96', '43/96', '47/96', '49/96', '53/96', '55/96', '59/96', '61/96', '65/96', '67/96', '71/96', '73/96', '77/96', '79/96', '83/96', '85/96', '89/96', '91/96', '95/96'], ['1/97', '2/97', '3/97', '4/97', '5/97', '6/97', '7/97', '8/97', '9/97', '10/97', '11/97', '12/97', '13/97', '14/97', '15/97', '16/97', '17/97', '18/97', '19/97', '20/97', '21/97', '22/97', '23/97', '24/97', '25/97', '26/97', '27/97', '28/97', '29/97', '30/97', '31/97', '32/97', '33/97', '34/97', '35/97', '36/97', '37/97', '38/97', '39/97', '40/97', '41/97', '42/97', '43/97', '44/97', '45/97', '46/97', '47/97', '48/97', '49/97', '50/97', '51/97', '52/97', '53/97', '54/97', '55/97', '56/97', '57/97', '58/97', '59/97', '60/97', '61/97', '62/97', '63/97', '64/97', '65/97', '66/97', '67/97', '68/97', '69/97', '70/97', '71/97', '72/97', '73/97', '74/97', '75/97', '76/97', '77/97', '78/97', '79/97', '80/97', '81/97', '82/97', '83/97', '84/97', '85/97', '86/97', '87/97', '88/97', '89/97', '90/97', '91/97', '92/97', '93/97', '94/97', '95/97', '96/97'], ['1/98', '3/98', '5/98', '9/98', '11/98', '13/98', '15/98', '17/98', '19/98', '23/98', '25/98', '27/98', '29/98', '31/98', '33/98', '37/98', '39/98', '41/98', '43/98', '45/98', '47/98', '51/98', '53/98', '55/98', '57/98', '59/98', '61/98', '65/98', '67/98', '69/98', '71/98', '73/98', '75/98', '79/98', '81/98', '83/98', '85/98', '87/98', '89/98', '93/98', '95/98', '97/98'], ['1/99', '2/99', '4/99', '5/99', '7/99', '8/99', '10/99', '13/99', '14/99', '16/99', '17/99', '19/99', '20/99', '23/99', '25/99', '26/99', '28/99', '29/99', '31/99', '32/99', '34/99', '35/99', '37/99', '38/99', '40/99', '41/99', '43/99', '46/99', '47/99', '49/99', '50/99', '52/99', '53/99', '56/99', '58/99', '59/99', '61/99', '62/99', '64/99', '65/99', '67/99', '68/99', '70/99', '71/99', '73/99', '74/99', '76/99', '79/99', '80/99', '82/99', '83/99', '85/99', '86/99', '89/99', '91/99', '92/99', '94/99', '95/99', '97/99', '98/99'], ['1/100', '3/100', '7/100', '9/100', '11/100', '13/100', '17/100', '19/100', '21/100', '23/100', '27/100', '29/100', '31/100', '33/100', '37/100', '39/100', '41/100', '43/100', '47/100', '49/100', '51/100', '53/100', '57/100', '59/100', '61/100', '63/100', '67/100', '69/100', '71/100', '73/100', '77/100', '79/100', '81/100', '83/100', '87/100', '89/100', '91/100', '93/100', '97/100', '99/100']]

class Solution:
    def simplifiedFractions(self, n: int) -> List[str]:
        # Precomputation code.
        # fractions = [[]  for _ in range(101)]
        # fractions[1] = ['1/2']
        # primes = self.get_prime()

        # for i in range(2, 101):
        #     fraction = fractions[i]
        #     for j in range(1, i):
        #         for p in primes:
        #             if j % p == 0 and i % p == 0:
        #                 break
        #         else:
        #             fraction.append(f'{j}/{i}')
        # print(fractions)

        res = []
        for i in range(n + 1):
            res.extend(FRACTIONS[i])
        return res

    def get_prime(self):
        primes = []
        for i in range(2, 101):
            for j in range(2, i // 2 + 1):
                if i % j == 0:
                    break
            else:
                primes.append(i)
        return primes


def main():
    sol = Solution()
    print(sol.simplifiedFractions(4))
    print(sol.simplifiedFractions(1))
    print(sol.simplifiedFractions(3))


if __name__ == '__main__':
    main()
